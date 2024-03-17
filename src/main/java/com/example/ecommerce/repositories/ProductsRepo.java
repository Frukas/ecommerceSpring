package com.example.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.models.Products;

public interface ProductsRepo extends JpaRepository<Products, Long>{

}
