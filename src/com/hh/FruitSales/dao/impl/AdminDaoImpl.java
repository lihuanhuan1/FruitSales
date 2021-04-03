package com.hh.FruitSales.dao.impl;
import com.hh.FruitSales.bean.Admin;
import com.hh.FruitSales.dao.AdminDao;
import com.hh.FruitSales.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lhh
 * @create 2021-03-10-20:45
 */
public class AdminDaoImpl implements AdminDao {

    @Override
    public int addAdmin(Admin admin) {
        String sql="insert into admin_tbl(name,password)values(?,?)";
        JDBCUtils.update(sql,admin.getName(),admin.getPassword());
        return 0;
    }

    @Override
    public int update(Admin admin) {
        String sql="update admin_tbl set name=?,password=?where id=?";
        JDBCUtils.update(sql,admin.getName(),admin.getPassword(),admin.getId());
        return 0;
    }

    @Override
    public List<Admin> queryAll() {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Admin> list=new ArrayList<>();
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from admin_tbl";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Admin admin = new Admin(rs.getInt("id"), rs.getString("name"), rs.getString("password"));
                list.add(admin);
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
    public Admin queryOneByName(String name) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Admin admin=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from admin_tbl where name=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if(rs.next()){
                admin=new Admin(rs.getInt("id"),rs.getString("name"),rs.getString("password"));
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
        return admin;
    }
}
