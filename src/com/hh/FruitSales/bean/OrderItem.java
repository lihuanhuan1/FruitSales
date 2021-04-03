package com.hh.FruitSales.bean;

import java.math.BigDecimal;

/**
 * @author lhh
 * @create 2021-03-10-20:33
 */
public class OrderItem {
    private Integer id;
    private String oid;
    private Integer fid;
    private BigDecimal fCount;
    private BigDecimal price;

    public OrderItem() {
    }

    public OrderItem(Integer id, String oid, Integer fid, BigDecimal fCount, BigDecimal price) {
        this.id = id;
        this.oid = oid;
        this.fid = fid;
        this.fCount = fCount;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public BigDecimal getfCount() {
        return fCount;
    }

    public void setfCount(BigDecimal fCount) {
        this.fCount = fCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", oid='" + oid + '\'' +
                ", fid=" + fid +
                ", fCount=" + fCount +
                ", price=" + price +
                '}';
    }
}
