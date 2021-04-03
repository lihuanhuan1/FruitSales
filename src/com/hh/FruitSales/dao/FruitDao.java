package com.hh.FruitSales.dao;

import com.hh.FruitSales.bean.Admin;
import com.hh.FruitSales.bean.Fruit;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lhh
 * @create 2021-03-11-15:26
 */
public interface FruitDao {
    public  String addFruit(Fruit fruit);
    public BigDecimal update(Fruit fruit);
    public List<Fruit> queryAll();
    public Fruit queryOneByName(String name);
    public void deleFruit(Fruit fruit);
}
