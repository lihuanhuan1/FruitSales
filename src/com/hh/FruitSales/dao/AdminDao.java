package com.hh.FruitSales.dao;

import com.hh.FruitSales.bean.Admin;

import java.util.List;

/**
 * @author lhh
 * @create 2021-03-10-20:37
 */
public interface AdminDao {
    public  int addAdmin(Admin admin);
    public  int update(Admin admin);
    public List<Admin> queryAll();
    public  Admin queryOneByName(String name);
}
