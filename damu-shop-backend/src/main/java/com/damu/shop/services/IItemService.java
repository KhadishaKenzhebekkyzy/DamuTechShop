package com.damu.shop.services;

import com.damu.shop.entities.Items;

import java.util.List;
import java.util.Optional;

public interface IItemService {

    List<Items> findAll();
    Optional<Items> findById(Long id);
}
