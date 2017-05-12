<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/5/8
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  %>


  <title>登录界面</title>
    <link href="<%=basePath%>css/login.css" type="text/css" rel="stylesheet">

  <script>
      function s_login() {
          targetForm = document.forms[0];
          targetForm.action="studentlogin";
      }

      function t_login() {
          targetForm = document.forms[0];
          targetForm.action ="teacherlogin";
      }

      function a_login() {
          targetForm = document.forms[0];
          targetForm.action = "adminlogin";
      }

  </script>


  </head>

  <body>

  <div class="login">
    <div class="message">教务管理系统</div>
    <div id="darkbannerwrap"></div>
    <s:form method="post" id="theform" action="studentlogin.action">
      <input name="userID" placeholder="用户名" required="" type="text">
      <hr class="hr15">
      <input name="password" placeholder="密码" required="" type="password">
      <hr class="hr15">


      <input type="radio" name="logintype" value="学生"  onclick="s_login()"> 学生
      <input type="radio" name="logintype" value="教师" onclick="t_login()"> 教师
      <input type="radio" name="logintype" value="管理员" onclick="a_login()"> 管理员
      <hr class="hr15">
      <input value="登录" style="width:100%;" type="submit">
      <hr class="hr20">
    </s:form>
  </div>


  </body>
</html>
