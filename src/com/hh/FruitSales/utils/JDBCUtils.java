package com.hh.FruitSales.utils;

import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 获得数据库连接
 */
public class JDBCUtils {


    /**
     * @return
     * @throws Exception
     * @Description获取数据库链接
     * @author sxy
     * @date 2020年8月5日下午4:21:09
     */
    public static Connection getConnection() throws Exception {
        //建立数据库连接
        String user ="root";
        String password ="root";
        String url = "jdbc:mysql://localhost:3306/fruitsales?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
        String driverClass = "com.mysql.jdbc.Driver";
        // 加载驱动
        Class.forName(driverClass);
        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * @param conn
     * @param ps
     * @Description 关闭链接和Statement的操作
     * @author sxy
     * @date 2020年8月5日下午4:23:32
     */

    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String sql,Object...args){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn=JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            boolean execute = ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.closeResource(conn, ps,null);
        }
    }
}
