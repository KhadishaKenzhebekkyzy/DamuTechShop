package com.damu.shop.repositories;

import com.damu.shop.entities.Category;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findByCategoryname(String categoryname);
}
