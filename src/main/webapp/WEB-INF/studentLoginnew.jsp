<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/5/8
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>

    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">
    <title>学生登录页面</title>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="page-header">
                <h3>
                    学生选课界面 <small>欢迎学号:<s:property value="#session.userID"/> </small>
                </h3>
            </div>
            <ul class="nav nav-pills">
                <li class="active">
                    <a href="#">首页</a>
                </li>
                <li>
                    <a href="#">资料</a>
                </li>
                <li class="disabled">
                    <a href="#">信息</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span8"  id="resultpage">
            <iframe name="cont"  height="100%" width="100%" frameborder="0px">
            </iframe>

        </div>
        <div class="span4">
            <ul class="nav nav-list">
                <li class="nav-header">
                    常用操作
                </li>
                <li class="active">
                    <a href="<s:url action="turn_sC"/> " target="cont">选课</a>
                </li>
                <li>
                    <a href="<s:url action="turn_tK"/>" target="cont" >退课</a>
                </li>
                <li class="nav-header">
                    常用查询
                </li>
                <li>
                    <a href="<s:url action="test"/>" target="cont">课程查询</a>
                </li>
                <li>
                    <a href="<s:url action="schedule"/>" target="cont">个人信息</a>
                </li>
                <li>
                    <a href="#"></a><a href="http://www.bootcss.com/p/layoutit/#">删除课程</a>
                </li>
                <li class="divider">
                </li>
                <li>
                    <a href="#">帮助</a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
