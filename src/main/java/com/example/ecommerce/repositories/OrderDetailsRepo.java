package com.example.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.models.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {

}
