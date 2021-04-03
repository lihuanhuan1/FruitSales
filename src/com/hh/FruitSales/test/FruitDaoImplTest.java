package com.hh.FruitSales.test;

import com.hh.FruitSales.bean.Admin;
import com.hh.FruitSales.bean.Fruit;
import com.hh.FruitSales.dao.AdminDao;
import com.hh.FruitSales.dao.FruitDao;
import com.hh.FruitSales.dao.impl.AdminDaoImpl;
import com.hh.FruitSales.dao.impl.FruitDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lhh
 * @create 2021-03-11-17:25
 */
public class FruitDaoImplTest {
    FruitDao fruitDao = new FruitDaoImpl();
    @Test
    public void addFruit() {
        fruitDao.addFruit(new Fruit(null,"香蕉",new BigDecimal(5),new BigDecimal(2),9));
    }

    @Test
    public void update() {
        fruitDao.update(new Fruit(1,"香蕉",new BigDecimal(5),new BigDecimal(2),9));
    }

    @Test
    public void queryAll() {
        List<Fruit> fruits = fruitDao.queryAll();
        for (Fruit fruit: fruits) {
            System.out.println(fruit);
        }
    }

    @Test
    public void queryOneByName() {
        System.out.println(fruitDao.queryOneByName("香蕉"));
    }
    @Test
    public void deleFruit() {
        fruitDao.deleFruit(new Fruit(2,"香蕉",new BigDecimal(5),new BigDecimal(2),9));
    }
}