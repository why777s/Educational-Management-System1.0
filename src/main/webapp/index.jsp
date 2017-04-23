<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!azzz</h2>
<s:form action="login">
    <s:textfield name="userID"/>
    <s:password name="password"/>
    <s:submit value="登录"/>
</s:form>
</body>
</html>
