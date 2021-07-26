package com.damu.shop.services;

import com.damu.shop.entities.Items;
import com.damu.shop.entities.Order;
import com.damu.shop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private OrderRepository orderRepository;

    public OrderService(){
    }

    public List<Order> getOrders(){
        return this.findAll();
    }

    public Order saveOrders(Order order){
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

}
