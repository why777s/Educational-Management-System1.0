<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/28
  Time: 11:20
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
    <title>管理员登录页面</title>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="page-header">
                <h3>
                    管理员操作界面 <small>by why777s</small>
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
                    常用查询
                </li>
                <li>
                    <a href="<s:url action="turnAdIn"/>" target="cont">个人信息</a>
                </li>
                <li>
                    <a href="<s:url action="turnstuin"/>" target="cont">学生信息</a>
                </li>
                <li>
                    <a href="<s:url action="turnteaIn"/>" target="cont">教师信息</a>
                </li>
                <li>
                    <a href="<s:url action="turnCinfo"/>" target="cont">课程信息</a>
                </li>
                <li class="nav-header">
                    课程管理
                </li>
                <li>
                    <a href="<s:url action="kcgl"/>" target="cont">课程修改</a>
                </li>

                <li><a href="<s:url action="addC"/>" target="cont">课程添加</a></li>
                <li><a>课程删除</a></li>

                <li class="nav-header">
                    教师管理
                </li>
                <li>
                    <a href="<s:url action="jsxg"/> " target="cont" >教师修改</a>
                </li>
                <li><a>添加教师</a></li>
                <li class="nav-header">
                    其余操作
                </li>
                <li>
                    <a href="<s:url action="turnKFXK"/>" target="cont">开放选课</a>
                </li>

                <li class="divider">
                </li>
                <li>
                    <a href="#">帮助</a>
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
