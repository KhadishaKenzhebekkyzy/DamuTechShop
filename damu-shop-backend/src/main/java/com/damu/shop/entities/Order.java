package com.damu.shop.entities;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    public Order() {
    }

    public Order(Long orderid, Long itemid, Long userid) {
        this.orderid = orderid;
        this.itemid = itemid;
        this.userid = userid;
    }

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;

    @Column(name = "item_id")
    private Long itemid;

    @Column(name = "user_id")
    private Long userid;

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
