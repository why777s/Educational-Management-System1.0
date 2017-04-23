<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/17
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <title>学生选课界面</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/studentLogin.css">
</head>
<body>

    <div id="header" >
        学生选课界面
        <h4>欢迎 学号：<s:property value="#session.userID"/>   登录 </h4>
    </div>

    <div id="left_content">
        <p>常用功能</p>
        <ul>
            <li>
                <a href="<s:url action="turn_sC"/> " target="cont">选课</a></li>
            <li>
                <a>退课</a>
            </li>
        </ul>
        <p>数据查询</p>
        <ul>
            <li>
                <a href="<s:url action="test"/>" target="cont">查看课程</a>
            </li>
            <li>
                <a href="<s:url action="schedule"/>" target="cont">查看课表</a>
            </li>
            <li>删除课程查询</li>
        </ul>
    </div>

    <div id="main_content" >
        <iframe id="content" name="cont" frameborder="0px" height="100%" width="100%" >
        </iframe>
    </div>
</body>
</html>
