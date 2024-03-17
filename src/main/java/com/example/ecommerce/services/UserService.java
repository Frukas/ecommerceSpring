package com.example.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.ecommerce.models.Users;
import com.example.ecommerce.repositories.UsersRepo;

@Service
public class UserService {
    
    @Autowired
    private UsersRepo repo;

    public void registration(@NonNull Users user){    

        repo.save(user);
    }

    public void deletion(@NonNull Users user){
        repo.delete(user);
    }

    public List<Users> getAllUsers(){
        return repo.findAll();
    }

    public Users findUserByID(long id){
        return repo.getReferenceById(id);
    }
}
