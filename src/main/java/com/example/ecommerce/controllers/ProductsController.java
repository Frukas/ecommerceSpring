package com.example.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.example.ecommerce.dto.ProductDTO;
import com.example.ecommerce.models.Products;
import com.example.ecommerce.services.CategoryService;
import com.example.ecommerce.services.OrderdetailsService;
import com.example.ecommerce.services.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

@Controller
public class ProductsController {

    private final String REDIRECT = "redirect:/product";

    @Autowired
    private ProductService productService; 

    @Autowired
    private CategoryService categoryService; 
    
    @Autowired
    private OrderdetailsService orderdetailsService;


    @GetMapping("/")
    public String getIndexLandingPage(Model model) {   
        model.addAttribute("product", new ProductDTO()); 
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("productCount", orderdetailsService.getProductCount());

        return "product";
    }
    
    @GetMapping("/product")
    public String getLandingPage(Model model) {   
        model.addAttribute("product", new ProductDTO()); 
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("productCount", orderdetailsService.getProductCount());

        return "product";
    }

    @PostMapping("/registerProduct")
    public String registerProduct(@ModelAttribute("product") ProductDTO product) {

        Products newProduct = new Products(product.getProductName(),
                                            categoryService.findCategoryById(product.getCategoryID()), 
                                            product.getPrice(),
                                            product.getLocalDateTime(),
                                            product.getLocalDateTime()); 

        productService.registration(newProduct);
        
        return REDIRECT;        
    }        

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") ProductDTO product) { 

        Products newProduct = new Products(); 

        newProduct.setProductName(product.getProductName());       
        newProduct.setProductId(product.getProductId());
        newProduct.setCategory(categoryService.findCategoryById(product.getCategoryID()));
        newProduct.setPrice( product.getPrice());
        newProduct.setCreatedAt(productService.findProductsByID(product.getProductId()).getCreatedAt());
        newProduct.setUpdatedAt(product.getLocalDateTime());

        productService.registration(newProduct);

        return REDIRECT;        
    }

    @PostMapping("/deleteProduct")    
    public String deleteProduct(@ModelAttribute("product") ProductDTO product, RedirectAttributes redirectAttrs){

        try {
            productService.deletion(productService.findProductsByID(product.getProductId()));
        } catch (DataIntegrityViolationException e) {
            redirectAttrs.addFlashAttribute("error", "Cannot delete category. It is being used elsewhere.");
            return REDIRECT;
        }        
 
        return REDIRECT;  
    }
}
