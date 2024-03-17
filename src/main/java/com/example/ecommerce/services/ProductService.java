package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.models.Products;
import com.example.ecommerce.repositories.ProductsRepo;

@Service
public class ProductService {

    @Autowired
    private ProductsRepo repo;

    public void registration(Products product){
        repo.save(product);
    }

    public void deletion(Products product){
        repo.delete(product);
    }

   public List<Products> getAllProducts(){
       return repo.findAll();
   }

   public Products findProductsByID(long id){
        return repo.getReferenceById(id);
   }
}
