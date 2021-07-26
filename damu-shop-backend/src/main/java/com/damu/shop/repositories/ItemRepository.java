package com.damu.shop.repositories;

import com.damu.shop.entities.Category;
import com.damu.shop.entities.Items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Items, Long> {

    Items findByItemname(String itemname);
}
