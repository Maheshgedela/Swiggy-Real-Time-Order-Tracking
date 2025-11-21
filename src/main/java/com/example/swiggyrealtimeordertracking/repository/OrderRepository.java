package com.example.swiggyrealtimeordertracking.repository;

import com.example.swiggyrealtimeordertracking.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
