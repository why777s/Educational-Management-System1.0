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


    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">


    <script>
        function getHelp() {
            alert("若需要帮助，请拨打电话XXXX-XXXX，或至办公室XXX");
        }
    </script>

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
                <li class="divider">
                </li>
                <li>
                    <a href="#" onclick="getHelp()">帮助</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <h5>
                14122907 王赵俊
            </h5>
        </div>
    </div>
</div>
</body>
</html>
