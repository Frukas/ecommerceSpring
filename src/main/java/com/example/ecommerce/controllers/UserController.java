package com.example.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ecommerce.dto.UserDTO;
import com.example.ecommerce.models.Users;
import com.example.ecommerce.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private static final String REDIRECT = "redirect:/customer";

    @Autowired
    private UserService userService;
    
    @GetMapping("/customer")
    public String landingPage(Model model) {
            model.addAttribute("user", new UserDTO());
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

        Users newUser = new Users();
        newUser.setUserId(user.getUserId());
        newUser.setFirstName(user.getFirstName());
        newUser.setMail(user.getMail());
        newUser.setPhone(user.getPhone());
        newUser.setAddress(user.getAddress());
        newUser.setCreatedAt(userService.findUserByID(user.getUserId()).getCreatedAt());
        newUser.setUpdatedAt(user.getLocalDateTime());

        userService.registration(newUser);
        
        return REDIRECT;
    }

    @PostMapping("/deleteCostumer")
    public String deleteCostumer(@ModelAttribute("user") UserDTO user, RedirectAttributes redirectAttrs) {

        try {
            userService.deletion(userService.findUserByID(user.getUserId()));
        } catch (DataIntegrityViolationException e) {
            redirectAttrs.addFlashAttribute("error", "Cannot delete category. It is being used elsewhere.");
        } 

        return REDIRECT;
    }
    
    
}
