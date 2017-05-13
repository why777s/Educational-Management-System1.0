<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师开课情况</title>
    <%
        String qqqqq = (String)session.getAttribute("userID");
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script>
        <s:if test="#request.message1!=null">
        alert("<s:property value="#request.message1"/>")
        </s:if>
    </script>
</head>
<body>
<table class="table table-hover table-bordered">
    <tr>
        <th>课程学期</th>
        <th>课程号</th>
        <th>课程名</th>
        <th>学分</th>
        <th>上课时间</th>
    </tr>
    <s:iterator status="st" value="#request.openCourseList" id="tsc">
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
        <td> <s:property value="#tsc.semester"/> </td>
        <td> <s:property value="#tsc.cid"/> </td>
        <td> <s:property value="#tsc.courseByCid.cname"/> </td>
        <td> <s:property value="#tsc.courseByCid.ccredit"/> </td>
        <td> <s:property value="#tsc.time"/> </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>