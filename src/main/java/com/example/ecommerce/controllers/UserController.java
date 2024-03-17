package com.example.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ecommerce.dto.UserDTO;
import com.example.ecommerce.models.Users;
import com.example.ecommerce.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    private static final String REDIRECT = "redirect:/customer";

    @Autowired
    private UserService userService;
    
    @GetMapping("/customer")
    public String landingPage(Model model) {
            model.addAttribute("user", new Users());
            model.addAttribute("users", userService.getAllUsers());

        return "customer";
    }

    @PostMapping("/registerCustomer")
    public String registerCustomer(@ModelAttribute("user") UserDTO user) {

        Users newUsers = new Users();
        newUsers.setFirstName(user.getFirstName());
        newUsers.setMail(user.getMail());
        newUsers.setPhone(user.getPhone());
        newUsers.setAddress(user.getAddress());
        newUsers.setUpdatedAt(user.getLocalDateTime());
        newUsers.setCreatedAt(user.getLocalDateTime()); 
        
        userService.registration(newUsers);
        
        return REDIRECT;
    }  
    
    @PostMapping("/updateCustomer")
    public String postMethodName(@ModelAttribute("user") UserDTO user) {
        System.out.println(user.getFirstName());
        System.out.println(user.getMail());
        System.out.println(user.getPhone());
        System.out.println(user.getAddress());
        System.out.println(user.getCreatedAt());

        
        return REDIRECT;
    }
    
}
