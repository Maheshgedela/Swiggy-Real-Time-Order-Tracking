package com.example.swiggyrealtimeordertracking.services;


import com.example.swiggyrealtimeordertracking.entity.Order;
import com.example.swiggyrealtimeordertracking.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

        // Create new order
        public Order createOrder(Order order) {
            order.setStatus("PLACED");
            order.setUpdatedAt(LocalDateTime.now());
            return orderRepository.save(order);
        }

        // Update status
        public Order updateOrderStatus(Long id, String status) {
            Order order = orderRepository.findById(id).orElseThrow();
            order.setStatus(status);
            order.setUpdatedAt(LocalDateTime.now());
            return orderRepository.save(order);
        }

        // Get order by id
        public Order getOrder(Long id) {
            return orderRepository.findById(id).orElseThrow();
        }

        // Get all orders
        public List<Order> getAllOrders() {
            return orderRepository.findAll();
        }
    }


