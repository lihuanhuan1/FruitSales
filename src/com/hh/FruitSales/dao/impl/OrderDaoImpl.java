package com.hh.FruitSales.dao.impl;

import com.hh.FruitSales.bean.Fruit;
import com.hh.FruitSales.bean.Order;
import com.hh.FruitSales.dao.OrderDao;
import com.hh.FruitSales.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lhh
 * @create 2021-03-12-16:12
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public String addOrder(Order order) {
        String sql="insert into order_tbl(id,create_time,total_price)values(?,?,?)";
        JDBCUtils.update(sql,order.getId(),order.getCreatTime(),order.getTotalPrice());
        return null;
    }

    @Override
    public List<Order> queryAll() {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Order> list=new ArrayList<>();
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from order_tbl";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Order order = new Order(rs.getString("id"), rs.getDate("create_time"),rs.getBigDecimal("total_price"));
                list.add(order);
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
    public Order queryOneById(String id) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Order order=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from order_tbl where id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
               order=new Order(rs.getString("id"), rs.getDate("create_time"),rs.getBigDecimal("total_price"));
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
        return order;
    }
}
