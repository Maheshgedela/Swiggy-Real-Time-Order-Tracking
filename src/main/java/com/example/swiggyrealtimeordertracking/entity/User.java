package com.example.swiggyrealtimeordertracking.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String role; // CUSTOMER / RESTAURANT / DELIVERY

        @Column(unique = true)
        private String username;

        private String password; // store BCrypt hash

        @Column(unique = true)
        private String phone; // E.164 recommended (+91...)
    }


