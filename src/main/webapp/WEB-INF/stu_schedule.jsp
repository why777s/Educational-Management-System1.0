<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/23
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body bgcolor="#e9967a">
<h>当前已选课程：</h>
<table bgcolor="#7fffd4" border="1px solid">
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>教室号</th>
        <th>上课时间</th>
    </tr>
    <s:iterator value="#request.sC_c_ts" id="sche">
        <tr>
            <td> <s:property value="#sche.cid"/> </td>
            <td> <s:property value="#sche.cname"/> </td>
            <td> <s:property value="#sche.tid"/> </td>
            <td> <s:property value="#sche.time"/> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
