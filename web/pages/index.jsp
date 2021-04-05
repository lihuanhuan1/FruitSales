<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2021/3/15
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">水果店销售系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">${sessionScope.user}</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">主页</a></li>
                <li><a href="#">订单管理<span class="sr-only">(current)</span></a></li>
                <li><a href="#">水果管理<span class="sr-only">(current)</span></a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">、
            <div class="row">
                <div class="col-md-4 col-md-offset-1">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>水果名</th>
                            <th>水果单价</th>
                            <th>水果数量</th>
                            <th>合计</th>
                        </tr>
                        </thead>
                        <tbody id="tbody">

                        </tbody>
                    </table>
                    <form action="addOrderServlet",method="post">
                        <input type="hidden"name="oid"id="oid">
                        <button type="submit" class="btn btn-default">创建订单</button>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">添加水果</button>
                    </form>
                </div>
                <div class="col-md-6 col-md-offset-1">
                    2
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加订单项</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="count">数量</label>
                        <input type="email" class="form-control" id="count" placeholder="请输入....">
                    </div>
               w     <select class="form-control"id="fruitSelect">
                        <c:forEach items="${sessionScope.FruitList}" var="fruit">
                            <option value="${fruit.id}" price="${fruit.price}">${fruit.name}</option>
                        </c:forEach>
                    </select>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary"id="addBtn">添加</button>
            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        $("#addBtn").click(function () {
            var fid = $("#fruitSelect").val();
            var count = $("#count").val();
            var fname = $("#fruitSelect").find("option:selected").text();
            var price = $("#fruitSelect").find("option:selected").attr("price");
            $("#tbody").append("<tr>\n" +
                "                            <td>"+fid+"</td>\n" +
                "                            <td>"+fname+"</td>\n" +
                "                            <td>"+price+"</td>\n" +
                "                            <td>"+count+"</td>\n" +
                "                            <td>"+price*count+"</td>\n" +
                "                        </tr>")
            $.ajax({
                url:"addOrderItemServlet",   //请求地址
                type:"get",   //请求方法
                data:{"fid":fid,"fname":fname,"count":count,"price":price},   //要发送的数据,相当于表单提交的数据，json形式。
                dataType:"text",   //期待返回的数据类型，也可以理解为请求的数据类型
                error:function () {  //发生错误时的处理
                    console.log("error request");
                },
                success:function (data) {  //成功时的处理。参数表示返回的数据
                    console.log(data);
                    alert("订单项添加成功！订单编号为："+data);
                    $("#oid").val(data);
                }

            })
        })
    })
</script>
</body>
</html>
