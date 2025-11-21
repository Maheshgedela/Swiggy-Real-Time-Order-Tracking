package com.example.swiggyrealtimeordertracking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
@Data
@AllArgsConstructor
public class OTPRecord {
        private String otp;
        private Instant expiresAt;

    }
