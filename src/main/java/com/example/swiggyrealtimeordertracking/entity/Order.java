package com.example.swiggyrealtimeordertracking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")



public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Long customerId;
        private Long restaurantId;
        private Long deliveryPartnerId;

        private String status; // PLACED | ACCEPTED | COOKING | PICKED | ARRIVING | DELIVERED

        private LocalDateTime updatedAt;
    }



