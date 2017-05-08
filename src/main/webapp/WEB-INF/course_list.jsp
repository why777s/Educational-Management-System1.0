<%@ page import="Dao.impl.CourseDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Course" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/18
  Time: 22:31
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

    <title>课程</title>
</head>
<body  onload="init()">
<form class="form-search">
    <input class="input-medium search-query" type="text" />
    <button type="submit" class="btn">查找</button>
</form>
<table  class="table table-hover table-bordered">
        <tr>
            <th>课程号:</th>
            <th>课程名</th>
            <th>学分</th>
            <th>开课院系号</th>
        </tr>
        <s:iterator value="courseList" status="st">
            <%-- 如果直接 #st%5==0 是不行的！--%>
            <%--<s:if test="#st.first">--%>
                <%--<tr class="">--%>
            <%--</s:if>--%>
            <s:if test="#st.getCount()%4==0">
                <tr class="success">
            </s:if>
            <s:elseif test="#st.getCount()%4==1">
                <tr class="error">
            </s:elseif>
            <s:elseif test="#st.getCount()%4==2">
                <tr class="warning">
            </s:elseif>
            <s:elseif test="#st.getCount()%4==3">
                <tr class="info">
            </s:elseif>
                <td> <s:property value="cid"/> </td>
                <td> <s:property value="cname"/> </td>
                <td> <s:property value="ccredit"/> </td>
                <td> <s:property value="collegeByYxh.yxh"/> </td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
