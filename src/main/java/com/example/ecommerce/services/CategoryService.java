package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.models.Category;
import com.example.ecommerce.repositories.CategoryRepo;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo repo;
    
    public void registration(Category category ){

        repo.save(category);
    }

    public void deletion(Category category){
        repo.delete(category);
    }

    public List<Category> getAllCategories(){   
                  
        return repo.findAll();
    }

    public Category findCategoryById(long id){
        return repo.getReferenceById(id);
    }
}
