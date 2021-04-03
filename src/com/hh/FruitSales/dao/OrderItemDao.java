package com.hh.FruitSales.dao;

import com.hh.FruitSales.bean.Order;
import com.hh.FruitSales.bean.OrderItem;

import java.util.List;

/**
 * @author lhh
 * @create 2021-03-12-16:10
 */
public interface OrderItemDao {
    public  void addOrderItem(OrderItem orderItem);
    public List<OrderItem> queryAll();
    public OrderItem queryOneById(int id);
}
