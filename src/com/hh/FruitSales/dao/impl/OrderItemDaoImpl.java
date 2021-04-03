package com.hh.FruitSales.dao.impl;

import com.hh.FruitSales.bean.Order;
import com.hh.FruitSales.bean.OrderItem;
import com.hh.FruitSales.dao.OrderItemDao;
import com.hh.FruitSales.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lhh
 * @create 2021-03-12-16:11
 */
public class OrderItemDaoImpl implements OrderItemDao {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        String sql="insert into order_item_tbl(oid,fid,fcount,price)values(?,?,?,?)";
        JDBCUtils.update(sql,orderItem.getOid(),orderItem.getFid(),orderItem.getfCount(),orderItem.getPrice());
    }

    @Override
    public List<OrderItem> queryAll() {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<OrderItem> list=new ArrayList<>();
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from order_item_tbl";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                OrderItem orderItem = new OrderItem(rs.getInt("id"),rs.getString("oid"),rs.getInt("fid"),rs.getBigDecimal("fcount"),rs.getBigDecimal("price"));
                list.add(orderItem);
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
    public OrderItem queryOneById(int id) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        OrderItem orderItem=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from order_item_tbl where id=?";
            ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if(rs.next()){
                orderItem=new OrderItem(rs.getInt("id"),rs.getString("oid"),rs.getInt("fid"),rs.getBigDecimal("fcount"),rs.getBigDecimal("price"));
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
        return orderItem;
    }
}
