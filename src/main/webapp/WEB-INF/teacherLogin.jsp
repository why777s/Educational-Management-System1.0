<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/24
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师管理界面</title>
        <%
            String path = request.getContextPath();
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        %>
        <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/studentLogin.css">
<body>
<div id="header" >
    教师管理界面
    <h4>欢迎 教师工号：<s:property value="#session.userID"/>   登录 </h4>
</div>

<div id="left_content">
    <p>常用功能</p>
    <ul>
        <li>
            <a href="<s:url action="turn_tSchedule"/> " target="cont">查看开课情况</a></li>
        <li>
            <a href="<s:url action="turn_Entry"/>" target="cont">成绩录入</a>
        </li>
    </ul>

</div>

<div id="main_content" >
    <iframe id="content" name="cont" frameborder="0px" height="100%" width="100%" >
    </iframe>
</div>
</body>
</html>