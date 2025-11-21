package com.example.swiggyrealtimeordertracking.services;


import com.example.swiggyrealtimeordertracking.entity.DeliveryLocation;
import com.example.swiggyrealtimeordertracking.repository.DeliveryLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryLocationRepository locationRepository;

        public DeliveryLocation updateLocation(Long orderId, Double lat, Double lng) {
            DeliveryLocation location = new DeliveryLocation();
            location.setOrderId(orderId);
            location.setLatitude(lat);
            location.setLongitude(lng);
            location.setUpdatedAt(LocalDateTime.now());

            return locationRepository.save(location);
        }

        public DeliveryLocation getLatestLocation(Long orderId) {
            return locationRepository.findTopByOrderIdOrderByUpdatedAtDesc(orderId);
        }
    }


