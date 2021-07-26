package com.damu.shop.services;

import com.damu.shop.entities.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {

    List<Order> findAll();
    Optional<Order> findById(Long id);
}
