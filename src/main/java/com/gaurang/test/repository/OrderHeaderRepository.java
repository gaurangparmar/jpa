package com.gaurang.test.repository;

import com.gaurang.test.entity.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader,Integer> {

    Optional<OrderHeader> findByOrderId(String orderId);
}
