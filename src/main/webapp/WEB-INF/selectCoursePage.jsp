<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/19
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课</title>

</head>
<body bgcolor="#f5deb3">
在这个页面选课
<table bgcolor="#adff2f" border="1px">
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>教师号</th>
        <th>上课时间</th>
        <th>学分</th>
    </tr>
    <s:iterator value="#request.course_openCourse_cids" id="kaikelist">
        <tr>
            <td> <s:property value="#kaikelist.cid"/> </td>
            <td> <s:property value="#kaikelist.cname"/> </td>
            <td> <s:property value="#kaikelist.tid"/> </td>
            <td> <s:property value="#kaikelist.time"/> </td>
            <td> <s:property value="#kaikelist.ccredit"/> </td>
            <%--<td> <a href="sC.action?list.cid=<s:property value="cid"/>">选课</a> </td>--%>
            <%--<td> <a href="sC.action?list.cid=<s:property value="#kaikelist.cid"/>">选课333</a> </td>--%>
            <td> <a href="<s:url action="sC">
                            <s:param name="kklist.cid"  value="%{cid}"/>
                            <s:param name="kklist.tid" value="%{tid}"/>
                            <s:param name="kklist.time" value="%{time}"/>
                            <s:param name="kklist.semester" value="%{semester}"/>
                          </s:url> ">
                  选课</a>
            </td>
        </tr>


    </s:iterator>



</table>

</body>
</html>
