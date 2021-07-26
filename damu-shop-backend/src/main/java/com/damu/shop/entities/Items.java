package com.damu.shop.entities;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Items {

    public Items() {
    }

    public Items(Long itemid, String itemname, Integer categoryid, Integer itemcount, Integer itemprice) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.categoryid = categoryid;
        this.itemcount = itemcount;
        this.itemprice = itemprice;
    }

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemid;

    @Column(name = "item_name")
    private String itemname;

    @Column(name = "category_id")
    private Integer categoryid;

    @Column(name = "item_count")
    private Integer itemcount;

    @Column(name = "item_price")
    private Integer itemprice;

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Integer getItemcount() {
        return itemcount;
    }

    public void setItemcount(Integer itemcount) {
        this.itemcount = itemcount;
    }

    public Integer getItemprice() {
        return itemprice;
    }

    public void setItemprice(Integer itemprice) {
        this.itemprice = itemprice;
    }
}
