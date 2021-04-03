package com.hh.FruitSales.dao;

import com.hh.FruitSales.bean.Order;
import sun.text.resources.cldr.ti.FormatData_ti_ER;

import java.util.List;

/**
 * @author lhh
 * @create 2021-03-12-16:12
 */
public interface OrderDao {
    public  String addOrder(Order order);
    public List<Order> queryAll();
    public Order queryOneById(String id);
}
