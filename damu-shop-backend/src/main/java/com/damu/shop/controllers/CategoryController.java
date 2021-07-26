package com.damu.shop.controllers;

import com.damu.shop.entities.Category;
import com.damu.shop.entities.Items;
import com.damu.shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@Component
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("getcategories")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("addcategories")
    public Category addCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("getcategory")
    public Category getCategory(String categoryname){
        return categoryService.getCategory(categoryname);
    }

    @GetMapping("getcategory/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id){
        return categoryService.findById(id);
    }
}
