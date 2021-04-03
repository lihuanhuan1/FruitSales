package com.hh.FruitSales.test;

import com.hh.FruitSales.bean.OrderItem;
import com.hh.FruitSales.dao.OrderItemDao;
import com.hh.FruitSales.dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lhh
 * @create 2021-03-12-17:18
 */
public class OrderItemDaoImplTest {
    OrderItemDao orderItemDao= new OrderItemDaoImpl();
    @Test
    public void addOrderItem() {
        orderItemDao.addOrderItem(new OrderItem(null,"1",1,new BigDecimal(5),new BigDecimal(5)));
    }

    @Test
    public void queryAll() {
        List<OrderItem> orderItems = orderItemDao.queryAll();
        for (OrderItem orderItem: orderItems) {
            System.out.println(orderItem);
        }
    }

    @Test
    public void queryOneById() {
        System.out.println(orderItemDao.queryOneById(2));
    }
}