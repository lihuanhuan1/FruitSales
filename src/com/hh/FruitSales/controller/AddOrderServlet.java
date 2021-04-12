package com.hh.FruitSales.controller;

import com.hh.FruitSales.bean.Order;
import com.hh.FruitSales.service.OrderItemService;
import com.hh.FruitSales.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lhh
 * @create 2021-04-05-15:06
 */
public class AddOrderServlet extends HttpServlet {
    OrderService orderService=new OrderService();
    OrderItemService orderItemService=new OrderItemService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String oid = request.getParameter("oid");
        System.out.println("oid = " + oid);
        BigDecimal totalPrice= orderItemService.getTotalPriceByOid(oid);
        System.out.println("totalPrice = " + totalPrice);
        orderService.createOrder(new Order(oid,new Date(),totalPrice));
        HttpSession session = request.getSession();
        session.removeAttribute("oid");
        response.sendRedirect("pages/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
