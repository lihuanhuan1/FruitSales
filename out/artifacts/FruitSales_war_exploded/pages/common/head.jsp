<%--
  Created by IntelliJ IDEA.
  User: 86187
  Date: 2021/3/15
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String basePath = request.getScheme()
+"://"
+ request.getServerName()
+ ":"
+ request.getServerPort()
+ request.getContextPath()
+ "/";
pageContext.setAttribute("basePath", basePath);
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/jquery-3.5.1.js"></script>
<link type="text/css" rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" >
<link type="text/css" rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/dashboard.css" >
<script type="text/javascript" src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
