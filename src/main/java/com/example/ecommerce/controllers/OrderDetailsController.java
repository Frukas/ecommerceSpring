package com.example.ecommerce.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ecommerce.dto.OrderDetailsDTO;
import com.example.ecommerce.models.OrderDetails;
import com.example.ecommerce.services.OrderdetailsService;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OrderDetailsController {

    @Autowired
    private OrderdetailsService orderdetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    private static final String REDIRECT = "redirect:/orderDetails";

    @GetMapping("/orderDetails")
    public String landingPage(Model model) {
        model.addAttribute("orderDetail", new OrderDetailsDTO());
        model.addAttribute("orderDetails", orderdetailsService.getAllOrderDetails());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("products", productService.getAllProducts());

        return "orderDetails";
    }

    @PostMapping("/registerOrderDetails")
    public String registerOrder(@ModelAttribute("orderDetail") OrderDetailsDTO orderDetail) {

        OrderDetails newOrderDetails = new OrderDetails();

        newOrderDetails.setUser(userService.findUserByID(orderDetail.getUserID()));
        newOrderDetails.setStatus(orderDetail.getStatus());
        newOrderDetails.setProduct(productService.findProductsByID(orderDetail.getProductId()));
        newOrderDetails.setQuantity(orderDetail.getQuantity());
        newOrderDetails.setPrice(productService.findProductsByID(orderDetail.getProductId()).getPrice()*orderDetail.getQuantity());
        newOrderDetails.setCreatedAt(LocalDateTime.now());
        newOrderDetails.setUpdatedAt(LocalDateTime.now());

        orderdetailsService.registration(newOrderDetails);
        
        return REDIRECT;
    }

    @PostMapping("/updateOrderDetails")
    public String postMethodName(@ModelAttribute("orderDetail") OrderDetailsDTO orderDetail) {

        OrderDetails newOrderDetails = new OrderDetails();
        newOrderDetails.setOrderId(orderDetail.getOrderId());
        newOrderDetails.setUser(userService.findUserByID(orderDetail.getUserID()));
        newOrderDetails.setStatus(orderDetail.getStatus());
        newOrderDetails.setProduct(productService.findProductsByID(orderDetail.getProductId()));
        newOrderDetails.setQuantity(orderDetail.getQuantity());
        newOrderDetails.setPrice(productService.findProductsByID(orderDetail.getProductId()).getPrice()*orderDetail.getQuantity());
        newOrderDetails.setCreatedAt(orderdetailsService.findOrderDetailById(orderDetail.getOrderId()).getUpdatedAt());
        newOrderDetails.setUpdatedAt(LocalDateTime.now());


        System.out.println(orderDetail.getOrderId());
        System.out.println(orderDetail.getProductId());
        System.out.println(orderDetail.getStatus());
        System.out.println(orderDetail.getUserID());
        System.out.println(orderDetail.getQuantity());

        orderdetailsService.registration(newOrderDetails);
        
        return REDIRECT;
    }
    
    
    

}
