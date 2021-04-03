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
                    <form>
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
                        <label for="exampleInputEmail1">数量</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入....">
                    </div>
                    <select class="form-control">
                        <c:forEach items="${sessionScope.FruitList}" var="fruit">
                            <option value="${fruit.id}">${fruit.name}</option>
                        </c:forEach>
                    </select>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">添加</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
