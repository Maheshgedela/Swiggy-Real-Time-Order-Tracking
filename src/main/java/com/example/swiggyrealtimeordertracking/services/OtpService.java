package com.example.swiggyrealtimeordertracking.services;


import com.example.swiggyrealtimeordertracking.entity.OTPRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class OtpService {
    private final Map<String, OTPRecord> cache = new ConcurrentHashMap<>();
        private final SmsService smsService; // implementation below

        private final int OTP_LENGTH = 6;
        private final Duration OTP_TTL = Duration.ofMinutes(5);

        public String generateNumericOtp(int length) {
            SecureRandom rnd = new SecureRandom();
            StringBuilder sb = new StringBuilder(length);
            for (int i=0;i<length;i++){
                sb.append(rnd.nextInt(10)); // 0-9
            }
            return sb.toString();
        }

        public void createAndSendOtp(String phone) {
            String otp = generateNumericOtp(OTP_LENGTH);
            Instant expiry = Instant.now().plus(OTP_TTL);
            cache.put(phone, new OTPRecord(otp, expiry));
            smsService.sendSms(phone, "Your Swiggy-Clone OTP is: " + otp + " (valid 5 minutes)");
        }

        public boolean verifyOtp(String phone, String otp) {
            OTPRecord rec = cache.get(phone);
            if (rec==null) return false;
            if (Instant.now().isAfter(rec.getExpiresAt())) {
                cache.remove(phone);
                return false;
            }
            boolean ok = rec.getOtp().equals(otp);
            if (ok) cache.remove(phone); // one-time
            return ok;
        }
    }






