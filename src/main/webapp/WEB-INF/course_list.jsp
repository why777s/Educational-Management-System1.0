<%@ page import="Dao.impl.CourseDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Course" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/18
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程</title>
</head>
<body bgcolor="aqua">
<h2>本学期开设的课程</h2>
    <table border="1px solid">
        <tr>
            <th>课程号</th>
            <th>课程名</th>
            <th>学分</th>
            <th>开课院系号</th>
        </tr>

        <s:iterator value="courseList">
            <tr>
                <td> <s:property value="cid"/> </td>
                <td> <s:property value="cname"/> </td>
                <td> <s:property value="ccredit"/> </td>
                <td> <s:property value="collegeByYxh.yxh"/> </td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
