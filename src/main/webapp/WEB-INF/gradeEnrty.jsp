<%@ page import="Entity.multiQuery.Course_OpenCourse_cid" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/24
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #tb1{
            text-align: center;
            border-collapse: collapse;
        }
    </style>
    <script>
        function chooseCourse() {
            var myselect = document.getElementById("ck");
            var index = myselect.selectedIndex;
            var value = myselect.options[index].value;
            var txt = myselect.options[index].text;
            alert(txt);
        }

        function update() {
            var tab = document.getElementById("tb1");
            var rows = tab.rows;
//            for(var i=0;i<rows.length;i++){
//                for(var j=0;j<rows[i].cells.length;j++){
                }

    </script>
</head>
<body >
登分页面
<h4>请选择您要登分的课程</h4>

<s:select id="ck" list="course_openCourse_cids" listValue="cname"
            headerKey="-1" headerValue="请选择要录入的课程" onchange="chooseCourse()"/>

<table id="tb1"  bgcolor="#7fffd4"  border="1px">
    <tr>
        <th>学号</th>
        <th>课程号</th>
        <th>平时成绩</th>
        <th>考试成绩</th>
        <th>操作</th>
    </tr>
    <s:iterator value="#request.scList" id="df">
        <tr>
            <td> <s:property value="#df.sid"/> </td>
            <td> <h4> <s:property value="#df.cid"/> </h4> </td>
            <td> <input type="text" value="<s:property value="#df.pscj"/>"> </td>
            <td> <input type="text" value="<s:property value="#df.kscj"/>"> </td>
        </tr>
    </s:iterator>
</table>

<s:submit value="保存修改"  action="#"/>

</body>
</html>
