<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/5/8
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>


    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<table class="table table-hover table-bordered">
    <caption>管理员信息</caption>
    <tr class="success">
        <td>
            工号:
        </td>
        <td>
            <s:property value="admin.adminId"/>
        </td>
    </tr>
    <tr class="info">
        <td>姓名:</td>
        <td>
            <s:property value="admin.adminName"/>
        </td>
    </tr>
    <tr class="error">
        <td>
            院系名:
        </td>
        <td>
            <s:property value="admin.collegeByYxh.yname"/>
        </td>
    </tr>
</table>

</body>
</html>
