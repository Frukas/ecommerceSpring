package com.example.ecommerce.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.models.OrderDetails;
import com.example.ecommerce.repositories.OrderDetailsRepo;

@Service
public class OrderdetailsService {

   @Autowired
   private OrderDetailsRepo repo;

    public void registration(OrderDetails order){
       
        LocalDateTime now = LocalDateTime.now();
        order.setCreatedAt(now);
        order.setUpdatedAt(now);

        repo.save(order);
    }

    public void update(OrderDetails order){
        order.setUpdatedAt(LocalDateTime.now());
        repo.delete(order);
    }
}
