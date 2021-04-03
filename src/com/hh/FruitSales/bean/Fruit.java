package com.hh.FruitSales.bean;

import java.math.BigDecimal;

/**
 * @author lhh
 * @create 2021-03-10-20:24
 */
public class Fruit {
    private Integer id;
    private  String name;
    private BigDecimal price;
    private BigDecimal coat;
    private  Integer sales;

    public Fruit() {
    }

    public Fruit(Integer id, String name, BigDecimal price, BigDecimal coat, Integer sales) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.coat = coat;
        this.sales = sales;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getCoat() {
        return coat;
    }

    public Integer getSales() {
        return sales;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCoat(BigDecimal coat) {
        this.coat = coat;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", coat=" + coat +
                ", sales=" + sales +
                '}';
    }
}
