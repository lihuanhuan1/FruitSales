package com.hh.FruitSales.controller;

import com.hh.FruitSales.bean.Fruit;
import com.hh.FruitSales.service.AdminService;
import com.hh.FruitSales.service.FruitService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author lhh
 * @create 2021-03-15-20:25
 */
public class IndexJumpServlet extends javax.servlet.http.HttpServlet {
    AdminService adminService=new AdminService();
    FruitService fruitService=new FruitService();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password1=adminService.checkedAdmin(username);
        if(password1==null){
            request.setAttribute("msg","用户名不存在!");
            request.getRequestDispatcher("pages/login.jsp").forward(request,response);
        }else if(password1.equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("user",username);
            List<Fruit> list=fruitService.getAll();
            session.setAttribute("FruitList",list);
            request.getRequestDispatcher("pages/index.jsp").forward(request,response);
        }else{
            request.setAttribute("msg","密码错误!");
            request.setAttribute("name",username);
            request.getRequestDispatcher("pages/login.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("跳转到这里了");
        doPost(request,response);
    }
}
