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
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">

    <title>退课</title>
    <script>
        <s:if test="#request.message !=null">
            alert("<s:property value="#request.message"/> ");
        </s:if>
    </script>
</head>
<body>

<table class="table table-hover table-bordered">
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>教师号</th>
        <th>操作</th>
    </tr>
    <s:iterator value="#request.scList" status="st">
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
            <td> <s:property value="cid"/> </td>
            <td>
                <s:property value="courseByCid.cname"/>
            </td>
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
