package com.hh.FruitSales.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author lhh
 * @create 2021-03-10-20:29
 */
public class Order {
    private String id;
    private Date creatTime;
    private BigDecimal totalPrice;

    public Order() {
    }

    public Order(String id, Date creatTime, BigDecimal totalPrice) {
        this.id = id;
        this.creatTime = creatTime;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", creatTime=" + creatTime +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
