package com.example.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ecommerce.dto.CategoryCountDTO;
import com.example.ecommerce.models.Products;

public interface ProductsRepo extends JpaRepository<Products, Long>{

     @Query(value= "SELECT p.categoryid as categoryID, COUNT(p.categoryid) as count FROM products p GROUP BY p.categoryid", nativeQuery=true)
    List<CategoryCountDTO> getCategoriesCount();

}
