<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/24
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师开课情况</title>
    <%
        String qqqqq = (String)session.getAttribute("userID");
    %>
</head>
<body>
<table bgcolor="#fff5ee" border="1px solid">
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>学分</th>
        <th>上课时间</th>
    </tr>
    <s:iterator value="#request.course_openCourse_cids" id="tsc">
        <tr>
            <td> <s:property value="#tsc.cid"/> </td>
            <td> <s:property value="#tsc.cname"/> </td>
            <td> <s:property value="#tsc.ccredit"/> </td>
            <td> <s:property value="#tsc.time"/> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
