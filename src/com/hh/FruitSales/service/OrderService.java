package com.hh.FruitSales.service;

import com.hh.FruitSales.bean.Order;
import com.hh.FruitSales.dao.OrderDao;
import com.hh.FruitSales.dao.impl.OrderDaoImpl;

/**
 * @author lhh
 * @create 2021-04-05-15:09
 */
public class OrderService {
    OrderDao orderDao=new OrderDaoImpl();
    public  void createOrder(Order order){
        orderDao.addOrder(order);
    }
}
