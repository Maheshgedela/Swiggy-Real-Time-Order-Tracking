package com.example.swiggyrealtimeordertracking.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeliveryController {
        @GetMapping("/delivery/{id}/page")
        public String deliveryPage(@PathVariable int id) {
            return "delivery-update";  // loads delivery-update.html
        }

        // 👉 Delivery Partner updates status + location
        @PostMapping("/delivery/update")
        public String updateDelivery(
                @RequestParam String status,
                @RequestParam double lat,
                @RequestParam double lng
        ) {
            System.out.println("Status: " + status);
            System.out.println("Lat: " + lat);
            System.out.println("Lng: " + lng);

            // Backend lo store chey (database / rider service etc.)
            // Ikkada logic add chesukovachu.

            return "redirect:/delivery/1/page"; // Refresh page
        }
    }


