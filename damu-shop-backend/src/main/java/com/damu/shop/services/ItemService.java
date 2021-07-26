package com.damu.shop.services;

import com.damu.shop.entities.Items;
import com.damu.shop.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService{

    @Autowired
    private ItemRepository itemRepository;

    public ItemService(){

    }

    public List<Items> getItems(){
        return this.findAll();
    }

    public Items saveItems(Items items){
        return itemRepository.save(items);
    }

    public Items getItem(String itemname){
        return itemRepository.findByItemname(itemname);
    }


    @Override
    public List<Items> findAll() {
        return (List<Items>) itemRepository.findAll();
    }

    @Override
    public Optional<Items> findById(Long id) {
        return itemRepository.findById(id);
    }
}
