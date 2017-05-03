<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/5/2
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退课</title>
</head>
<body>

<table id="tb1"  bgcolor="#f0fff0"  border="1px">
    <tr>
        <th>课程号</th>
        <th>教师号</th>
        <th>操作</th>
    </tr>
    <s:iterator value="#request.scList">
        <tr>
            <td> <s:property value="cid"/> </td>
            <td> <s:property value="tid"/> </td>
            <td> <a href="<s:url action="tK">
                            <s:param name="tklist.cid"  value="%{cid}"/>
                            <s:param name="tklist.tid" value="%{tid}"/>
                          </s:url> ">
                退课</a>
            </td>

        </tr>
    </s:iterator>
</table>

</body>
</html>
