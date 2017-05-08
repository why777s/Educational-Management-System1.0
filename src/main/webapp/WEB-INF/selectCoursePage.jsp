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

    <title>选课</title>
    <script>
        <s:if test="#request.message!=null">
            alert("<s:property value="#request.message"/>")
        </s:if>
    </script>

</head>
<body >
<table class="table table-hover table-bordered">
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>教师号</th>
        <th>上课时间</th>
        <th>学分</th>
        <th>操作</th>
    </tr>
    <s:iterator status="st" value="#request.course_openCourse_cids" id="kaikelist">
        <s:if test="#st.getCount()%4==0">
            <tr class="success">
        </s:if>
        <s:elseif test="#st.getCount()%4==1">
            <tr class="error">
        </s:elseif>
        <s:elseif test="#st.getCount()%4==2">
            <tr class="warning">
        </s:elseif>
        <s:elseif test="#st.getCount()%4==3">
            <tr class="info">
        </s:elseif>
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
