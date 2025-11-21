package com.example.swiggyrealtimeordertracking.controller;


import com.example.swiggyrealtimeordertracking.entity.Order;
import com.example.swiggyrealtimeordertracking.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
        private final SimpMessagingTemplate messagingTemplate;   // 🔥 Add this

        // Create order (customer side)
        @PostMapping("/order/create")
        @ResponseBody
        public Order createOrder(@RequestBody Order order) {
            return orderService.createOrder(order);
        }

        // Update order status (restaurant / delivery partner)
        @PostMapping("/order/{id}/status")
        @ResponseBody
        public Order updateStatus(@PathVariable Long id, @RequestParam String status) {

            Order order = orderService.updateOrderStatus(id, status);

            // 🔥 REAL-TIME BROADCAST to customers using WebSocket
            messagingTemplate.convertAndSend("/topic/order-status/" + id, order);

            return order;
        }

        // View Status Page (Customer)
        @GetMapping("/order/{id}/status-page")
        public String orderStatusPage(@PathVariable Long id, Model model) {

            Order order = orderService.getOrder(id);

            model.addAttribute("order", order);
            model.addAttribute("orderId", id);
            model.addAttribute("status", order.getStatus());

            return "order-status"; // order-status.html
        }
    }

