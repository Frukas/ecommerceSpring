package com.example.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ecommerce.dto.ProductCountDTO;
import com.example.ecommerce.models.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {

    @Query(value= "SELECT o.product_id as productID, COUNT(o.product_id) as count FROM order_details o GROUP BY o.product_id", nativeQuery=true)
    List<ProductCountDTO> getProductCount();
}
