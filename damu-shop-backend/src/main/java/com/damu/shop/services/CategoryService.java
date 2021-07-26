package com.damu.shop.services;

import com.damu.shop.entities.Category;
import com.damu.shop.entities.Items;
import com.damu.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(){

    }

    public List<Category> getCategories(){
        return this.findAll();
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category getCategory(String categoryname){
        return categoryRepository.findByCategoryname(categoryname);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
