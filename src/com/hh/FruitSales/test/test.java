package com.hh.FruitSales.test;

import com.hh.FruitSales.bean.Admin;
import com.hh.FruitSales.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sxy
 * @create 2021-03-08-15:26
 */
public class test {

    @Test
    public void test() {

//        try {
//            Admin admin = new Admin(1, "lhh1", "456");
//            String sql = "DELETE FROM admin_tbl WHERE id = ?";
//            JDBCUtils.update(sql, admin.getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Admin> list = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement("select * from admin_tbl");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Admin admin = new Admin(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"));
                list.add(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }
        for (Admin admin : list) {
            System.out.println(admin);
        }
    }


}
