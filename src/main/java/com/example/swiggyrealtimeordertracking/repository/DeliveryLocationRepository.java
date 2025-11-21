package com.example.swiggyrealtimeordertracking.repository;

import com.example.swiggyrealtimeordertracking.entity.DeliveryLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryLocationRepository  extends JpaRepository<DeliveryLocation,Long> {
    DeliveryLocation findTopByOrderIdOrderByUpdatedAtDesc(Long orderId);
}
