package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CategoryCountDTO;
import com.example.ecommerce.models.Products;
import com.example.ecommerce.repositories.ProductsRepo;

@Service
public class ProductService {

    @Autowired
    private ProductsRepo repo;

    public void registration(@NonNull Products product){
        repo.save(product);
    }

    public void deletion(@NonNull Products product){
        repo.delete(product);
    }

   public List<Products> getAllProducts(){
       return repo.findAll();
   }

   public Products findProductsByID(long id){
        return repo.getReferenceById(id);
   }

   public List<CategoryCountDTO> getCategoriesCount(){
    return repo.getCategoriesCount();
   }

}
