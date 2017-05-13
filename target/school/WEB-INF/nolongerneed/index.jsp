<%@ taglib prefix="s" uri="/struts-tags" %>
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
<h2>教务管理系统--登录界面</h2>
<s:form action="studentlogin">
    <s:textfield name="userID"/>
    <s:password name="password"/>

    <input type="radio" name="logintype" value="学生" onclick="s_login()">学生
    <input type="radio" name="logintype" value="教师" onclick="t_login()">教师
    <input type="radio" name="logintype" value="管理员" onclick="a_login()">管理员
    <s:submit value="登录"/>
</s:form>
</body>
</html>
