package com.damu.shop.entities;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    public Category() {
    }

    public Category(Long id, String categoryname) {
        this.id = id;
        this.categoryname = categoryname;
    }

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
