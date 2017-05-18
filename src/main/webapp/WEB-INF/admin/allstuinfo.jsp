<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/5/8
  Time: 18:42
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

<table  class="table table-hover table-bordered">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>籍贯</th>
        <th>院系号</th>
        <th>学分</th>
    </tr>
    <s:iterator value="studentList" status="st">
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
        <td> <s:property value="sid"/> </td>
        <td> <s:property value="sname"/> </td>
        <td> <s:property value="sex"/> </td>
        <td> <s:property value="jiguan"/> </td>
        <td> <s:property value="collegeByYxh.yxh"/> </td>
        <td> <s:property value="scredit"/> </td>
        </tr>
    </s:iterator>
</table>


</body>
</html>
