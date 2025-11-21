package com.example.swiggyrealtimeordertracking.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


import com.twilio.type.PhoneNumber;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    @Value("${twilio.account.sid}")
        private String accountSid;

        @Value("${twilio.auth.token}")
        private String authToken;

        @Value("${twilio.from.number}")
        private String fromNumber;

        private boolean twilioEnabled = false;

        @PostConstruct
        public void init() {
            try {
                // Check if real Twilio credentials are provided
                if (!"TEST_SID".equals(accountSid) && !"TEST_TOKEN".equals(authToken)) {
                    Twilio.init(accountSid, authToken);
                    twilioEnabled = true;
                    System.out.println("Twilio Enabled: Real SMS Sending Active");
                } else {
                    System.out.println("Twilio Disabled: Using Console OTP Mode");
                }
            } catch (Exception e) {
                System.out.println("Twilio initialization failed → Using console mode");
                twilioEnabled = false;
            }
        }

        public void sendSms(String to, String body) {
            if (twilioEnabled) {
                // REAL SMS MODE
                Message.creator(
                        new PhoneNumber(to),
                        new PhoneNumber(fromNumber),
                        body
                ).create();

                System.out.println("Real SMS sent to: " + to);
            } else {
                // DUMMY MODE
                System.out.println("DUMMY SMS → " + to + ": " + body);
            }
        }
    }


