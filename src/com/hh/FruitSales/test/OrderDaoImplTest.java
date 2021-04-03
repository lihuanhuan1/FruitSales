package com.hh.FruitSales.test;

import com.hh.FruitSales.bean.Order;
import com.hh.FruitSales.dao.OrderDao;
import com.hh.FruitSales.dao.impl.OrderDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lhh
 * @create 2021-03-15-20:03
 */
public class OrderDaoImplTest {
    OrderDao orderDao = new OrderDaoImpl();

    @Test public void addOrder() {
        String id = ""+System.currentTimeMillis();

        orderDao.addOrder(new Order(id,new Date(),new BigDecimal(100)));
    }

    @Test
    public void queryAll() {
        List<Order> orders = orderDao.queryAll();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void queryOneById() {
        Order order = orderDao.queryOneById("16158104101317");
        System.out.println(order);
    }
}