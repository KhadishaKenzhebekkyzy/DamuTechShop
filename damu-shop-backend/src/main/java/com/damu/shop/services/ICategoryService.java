package com.damu.shop.services;

import com.damu.shop.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Category> findAll();
    Optional<Category> findById(Long id);
}
