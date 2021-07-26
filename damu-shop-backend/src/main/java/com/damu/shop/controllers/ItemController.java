package com.damu.shop.controllers;

import com.damu.shop.entities.Items;
import com.damu.shop.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("getitems")
    public List<Items> getItemd(){
        return itemService.getItems();
    }

    @PostMapping("additems")
    public Items addItem(@RequestBody Items items){
        return itemService.saveItems(items);
    }

    @GetMapping("getitem/{id}")
    public Optional<Items> getItem(@PathVariable Long id){
        return itemService.findById(id);
    }

    @PutMapping("reduceditem/{id}")
    Items addedToCartItem(@RequestBody Items newItem, @PathVariable Long id, @PathVariable Integer quantity) {

        return itemService.findById(id)
                .map(item -> {
                    item.setItemcount(newItem.getItemcount()-quantity);
                    return itemService.saveItems(item);
                })
                .orElseGet(() -> {
                    newItem.setItemid(id);
                    return itemService.saveItems(newItem);
                });
    }

    @PutMapping("increaseditem/{id}")
    Items removedFromCartItem(@RequestBody Items newItem, @PathVariable Long id, @PathVariable Integer quantity) {

        return itemService.findById(id)
                .map(item -> {
                    item.setItemcount(newItem.getItemcount()+quantity);
                    return itemService.saveItems(item);
                })
                .orElseGet(() -> {
                    newItem.setItemid(id);
                    return itemService.saveItems(newItem);
                });
    }
}
