<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/5/8
  Time: 19:26
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
    <title>教师信息</title>
</head>
<body>

<table  class="table table-hover table-bordered">
    <tr>
        <th>工号</th>
        <th>教师名</th>
        <th>级别</th>
        <th>密码</th>
        <th>性别</th>
        <th>生日</th>
        <th>院系名</th>
        <th>月薪</th>
    </tr>
    <s:iterator value="teacherList" status="st">
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
        <td> <s:property value="tid"/> </td>
        <td> <s:property value="tname"/> </td>
        <td> <s:property value="title"/> </td>
        <td> <s:property value="password"/> </td>
        <td> <s:property value="sex"/> </td>
        <td> <s:property value="birthdate"/> </td>
        <td> <s:property value="collegeByYxh.yname"/> </td>
        <td> <s:property value="salary"/> </td>
        </tr>
    </s:iterator>
</table>

</body>
</html>
