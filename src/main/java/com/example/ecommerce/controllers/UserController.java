package com.example.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ecommerce.models.Users;
import com.example.ecommerce.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/customer")
    public String landingPage(Model model) {
            model.addAttribute("user", new Users());
            model.addAttribute("users", userService.getAllUsers());

        return "customer";
    }
    
}
