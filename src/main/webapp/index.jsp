<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function s_login() {
            targetForm = document.forms[0];
            targetForm.action="studentlogin";
        }

        function t_login() {
            targetForm = document.forms[0];
            targetForm.action ="teacherlogin";

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
    <s:submit value="   登录"/>
</s:form>
</body>
</html>
