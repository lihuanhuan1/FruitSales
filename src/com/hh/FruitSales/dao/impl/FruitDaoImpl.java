package com.hh.FruitSales.dao.impl;

import com.hh.FruitSales.bean.Admin;
import com.hh.FruitSales.bean.Fruit;
import com.hh.FruitSales.dao.FruitDao;
import com.hh.FruitSales.utils.JDBCUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lhh
 * @create 2021-03-11-15:33
 */
public class FruitDaoImpl implements FruitDao {
    @Override
    public String addFruit(Fruit fruit) {
        String sql="insert into fruit_tbl(name,price,cost,sales)values(?,?,?,?)";
        JDBCUtils.update(sql,fruit.getName(),fruit.getPrice(),fruit.getCoat(),fruit.getSales());
        return null;
    }

    @Override
    public BigDecimal update(Fruit fruit) {
        String sql="update fruit_tbl set name=?,price=?,cost=?,sales=? where id=?";
        JDBCUtils.update(sql,fruit.getName(),fruit.getPrice(),fruit.getCoat(),fruit.getSales(),fruit.getId());
        return null;
    }

    @Override
    public List<Fruit> queryAll() {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Fruit> list=new ArrayList<>();
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from fruit_tbl";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Fruit fruit = new Fruit(rs.getInt("id"), rs.getString("name"),rs.getBigDecimal("price"),rs.getBigDecimal("cost"),rs.getInt("sales"));
                list.add(fruit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return list;
    }

    @Override
    public Fruit queryOneByName(String name) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Fruit fruit=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from fruit_tbl where name=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if(rs.next()){
                fruit=new Fruit(rs.getInt("id"), rs.getString("name"),rs.getBigDecimal("price"),rs.getBigDecimal("cost"),rs.getInt("sales"));
            }else {
                JDBCUtils.closeResource(conn,ps,rs);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return fruit;
    }

    @Override
    public void deleFruit(Fruit fruit) {
        String sql="delete from fruit_tbl where id=?";
        JDBCUtils.update(sql,fruit.getId());
    }
}
