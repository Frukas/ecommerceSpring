package com.example.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.ecommerce.dto.CategoryDTO;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.services.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;  

    private final String REDIRECT = "redirect:/category";

    @GetMapping("/category")
    public String getLandingpage(Model model) {
        model.addAttribute("category", new CategoryDTO());
        model.addAttribute("categories", categoryService.getAllCategories());

        return "category";
    }

    @PostMapping("/registerCategory")
    public String registerCategory(@ModelAttribute("category") CategoryDTO category) {

        Category newCategory = new Category();
        newCategory.setCategoryName(category.getCategoryName());
        newCategory.setSerialNo(category.getSerialNo());
        newCategory.setCreatedAt(category.getLocalDateTime());
        newCategory.setUpdatedAt(category.getLocalDateTime());
        System.out.println(category.getLocalDateTime());
        categoryService.registration(newCategory);

        return REDIRECT;
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute("category") CategoryDTO category) {
        Category newCategory = new Category();
        newCategory.setCategoryID(category.getCategoryID());
        newCategory.setCategoryName(category.getCategoryName());
        newCategory.setSerialNo(category.getSerialNo());
        newCategory.setUpdatedAt(category.getLocalDateTime());
        newCategory.setCreatedAt(categoryService.findCategoryById(category.getCategoryID()).getCreatedAt());
        System.out.println(category.getLocalDateTime());
        categoryService.registration(newCategory);     
        
        return REDIRECT;
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(@ModelAttribute("category") CategoryDTO category, RedirectAttributes redirectAttrs) {
        
        try {
            categoryService.deletion(categoryService.findCategoryById(category.getCategoryID()));
          }
          catch(DataIntegrityViolationException e) {            
            redirectAttrs.addFlashAttribute("error", "Cannot delete category. It is being used elsewhere.");
            return REDIRECT;
          }  
          return REDIRECT;
    }
}
