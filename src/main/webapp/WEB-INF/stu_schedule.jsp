<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/23
  Time: 14:58
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

    <title></title>
</head>
<body >
<table class="table table-hover table-bordered">
    <caption>个人信息</caption>
    <tr class="success">
        <td>
            学号:
        </td>
        <td>
            <s:property value="me.sid"/>
        </td>
    </tr>
    <tr class="info">
        <td>姓名:</td>
        <td>
            <s:property value="me.sname"/>
        </td>
    </tr>
    <tr class="warning">
        <td>性别:</td>
        <td>
            <s:property value="me.sex"/>
        </td>
    </tr>
    <tr class="error">
        <td>
            院系名:
        </td>
        <td>
            <s:property value="me.collegeByYxh.yname"/>
        </td>
    </tr>
    <tr class="success">
        <td>
            总学分:
        </td>
        <td>
            <s:property value="me.scredit"/>
        </td>
    </tr>
</table>


<table class="table table-hover table-bordered">
    <caption>课程表</caption>
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>教室号</th>
        <th>上课时间</th>
    </tr>
    <s:iterator value="#request.sC_c_ts"  status="st" id="sche">
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
            <td> <s:property value="#sche.cid"/> </td>
            <td> <s:property value="#sche.cname"/> </td>
            <td> <s:property value="#sche.tid"/> </td>
            <td> <s:property value="#sche.time"/> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
