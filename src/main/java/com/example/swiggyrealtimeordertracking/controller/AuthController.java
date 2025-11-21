package com.example.swiggyrealtimeordertracking.controller;


import com.example.swiggyrealtimeordertracking.entity.User;
import com.example.swiggyrealtimeordertracking.repository.UserRepository;
import com.example.swiggyrealtimeordertracking.services.OtpService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthController {
        private final UserRepository userRepo;
        private final PasswordEncoder passwordEncoder;
        private final OtpService otpService;

        @GetMapping("/register")
        public String registerForm() { return "register"; }

        @PostMapping("/register")
        public String registerSubmit(@RequestParam String username,
                                     @RequestParam String password,
                                     @RequestParam String phone,
                                     @RequestParam String name) {

            User u = new User();
            u.setUsername(username);
            u.setPassword(passwordEncoder.encode(password));
            u.setPhone(phone);
            u.setName(name);
            u.setRole("CUSTOMER");
            userRepo.save(u);

            return "redirect:/login";
        }

        @GetMapping("/login")
        public String loginPage() { return "login"; }

        @PostMapping("/login-submit")
        public String loginSubmit(@RequestParam String username,
                                  @RequestParam String password,
                                  Model model,
                                  HttpSession session) {

            Optional<User> opt = userRepo.findByUsername(username);
            if (opt.isEmpty()) {
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }

            User user = opt.get();
            if (!passwordEncoder.matches(password, user.getPassword())) {
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }

            otpService.createAndSendOtp(user.getPhone());
            session.setAttribute("auth_username", username);

            return "redirect:/enter-otp";
        }

        @GetMapping("/enter-otp")
        public String enterOtpPage() { return "enter-otp"; }

        @PostMapping("/verify-otp")
        public String verifyOtp(@RequestParam String otp,
                                HttpSession session,
                                HttpServletRequest request) {

            String username = (String) session.getAttribute("auth_username");
            if (username == null) return "redirect:/login";

            User user = userRepo.findByUsername(username).orElseThrow();

            if (!otpService.verifyOtp(user.getPhone(), otp)) {
                request.setAttribute("error", "Invalid or expired OTP");
                return "enter-otp";
            }

            // Auth successful
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
                    );

            SecurityContextHolder.getContext().setAuthentication(token);

            session.removeAttribute("auth_username");

            return "redirect:/";
        }
    }


