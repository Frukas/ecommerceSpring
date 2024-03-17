package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.ProductCountDTO;
import com.example.ecommerce.models.OrderDetails;
import com.example.ecommerce.repositories.OrderDetailsRepo;

@Service
public class OrderdetailsService {

   @Autowired
   private OrderDetailsRepo repo;

    public void registration(OrderDetails order){
        repo.save(order);
    }

    public List<OrderDetails> getAllOrderDetails(){
        return repo.findAll();
    }

    public OrderDetails findOrderDetailById(long id){
        return repo.getReferenceById(id);
    }

    public List<ProductCountDTO> getProductCount(){
        return repo.getProductCount();
    }
}
