package com.hh.FruitSales.service;

import com.hh.FruitSales.bean.OrderItem;
import com.hh.FruitSales.dao.OrderItemDao;
import com.hh.FruitSales.dao.impl.OrderItemDaoImpl;

/**
 * @author lhh
 * @create 2021-04-05-14:10
 */
public class OrderItemService {
    OrderItemDao orderItemDao=new OrderItemDaoImpl();
    public void insertOrderItem(OrderItem orderItem){
        orderItemDao.addOrderItem(orderItem);

    }
}
