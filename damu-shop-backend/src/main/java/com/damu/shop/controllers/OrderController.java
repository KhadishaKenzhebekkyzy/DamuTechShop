package com.damu.shop.controllers;

import com.damu.shop.entities.Items;
import com.damu.shop.entities.Order;
import com.damu.shop.services.ItemService;
import com.damu.shop.services.OrderService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("cart")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @GetMapping("getorders")
    public List<Order> getItemd(){
        return orderService.getOrders();
    }

    @PostMapping("addorders")
    public Order addItem(@RequestBody Order order){
        return orderService.saveOrders(order);
    }

    @GetMapping("getorder/{id}")
    public Optional<Order> getOrder(@PathVariable Long id){
        return orderService.findById(id);
    }

}
