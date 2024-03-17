package com.example.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.models.Category;

public interface CategoryRepo extends JpaRepository<Category, Long>{

}
