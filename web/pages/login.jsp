<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2021/3/20
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>
<div class="row">
    <div class="col-md-3 col-md-offset-4"style="margin-top: 10%">
        <form action="indexJump" method="post">
            <div class="form-group">
                <label>用户名</label>
                <input type="text"name="username"value="${requestScope.name}" class="form-control"placeholder="请输入用户名">
            </div>
            <div class="form-group">
                <label>密码</label>
                <input type="password"name="password" class="form-control"placeholder="请输入密码">
            </div>
            <button type="submit"value="登录"class=" btn btn-primary"style="margin-left: 38%">登录</button>
            <p style="color: red">${requestScope.msg}</p>
        </form>
    </div>
</div>
</body>
</html>
