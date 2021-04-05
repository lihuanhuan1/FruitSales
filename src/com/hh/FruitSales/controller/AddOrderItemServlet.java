package com.hh.FruitSales.controller;

import com.hh.FruitSales.bean.Fruit;
import com.hh.FruitSales.bean.OrderItem;
import com.hh.FruitSales.service.FruitService;
import com.hh.FruitSales.service.OrderItemService;

import javax.lang.model.SourceVersion;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

/**
 * @author lhh
 * @create 2021-04-05-13:51
 */
public class AddOrderItemServlet extends HttpServlet {
    OrderItemService orderItemService=new OrderItemService();
    FruitService fruitService=new FruitService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String fid = request.getParameter("fid");
        String fname = request.getParameter("fname");
        String count = request.getParameter("count");
        String price = request.getParameter("price");
        int fid1 = Integer.parseInt(fid);
        BigDecimal count1 = new BigDecimal(count);
        BigDecimal price1 = new BigDecimal(price);
        System.out.println("fid1 = " + fid1);
        System.out.println("price1 = " + price1);
        System.out.println("count1 = " + count1);
        System.out.println("fname = " + fname);
        HttpSession session = request.getSession();
        String oid=(String)session.getAttribute("oid");
        if (null==oid){
            session.setAttribute("oid",""+System.currentTimeMillis());
            oid=(String)session.getAttribute("oid");
        }
        orderItemService.insertOrderItem(new OrderItem(null,oid,fid1,count1,price1.multiply(count1)));
        Fruit fruit= fruitService.getOneByFid(fid);
        Integer sales = fruit.getSales();
        int newSales=sales+Integer.parseInt(count);
        fruitService.updateSales(fid,newSales);
        PrintWriter writer = response.getWriter();
        writer.write(oid);
    }
}
