package com.hh.FruitSales.service;

import com.hh.FruitSales.bean.OrderItem;
import com.hh.FruitSales.dao.OrderItemDao;
import com.hh.FruitSales.dao.impl.OrderItemDaoImpl;

import java.math.BigDecimal;

/**
 * @author lhh
 * @create 2021-04-05-14:10
 */
public class OrderItemService {
    OrderItemDao orderItemDao=new OrderItemDaoImpl();

    public  BigDecimal getTotalPriceByOid(String oid) {
        return orderItemDao.getTotalPriceByOid(oid);
    }

    public void insertOrderItem(OrderItem orderItem){
        orderItemDao.addOrderItem(orderItem);

    }
}
