<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/5/12
  Time: 09:19
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
        <script>
        <s:if test="#request.message!=null">
        alert("<s:property value="#request.message"/>");
        </s:if>
        </script>
    <title>教师信息</title>
</head>
<body>
<s:form theme="simple" action="jinxingxiugai">
<table  class="table table-hover table-bordered">
    <tr>
        <th>工号</th>
        <th>教师名</th>
        <th>级别</th>
        <th>月薪</th>
        <th>院系名</th>
        <th>性别</th>
        <th>生日</th>
        <th>密码</th>

    </tr>
    <s:iterator value="teacherList" status="st">
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
        <td> <s:property value="tid"/>
            <s:hidden name="jieshoudetid" value="%{tid}"/>
        </td>
        <td> <s:textfield name="newtname" size="10" cssStyle="width:60px"  maxlength="10" value="%{tname}"/> </td>
        <td> <s:textfield name="newtitle" size="10" cssStyle="width:40px" maxlength="10" value="%{title}"/> </td>

        <td> <s:textfield name="newsalary" size="5" cssStyle="width:60px"  maxlength="5" value="%{salary}"/> </td>
        <td> <s:property value="collegeByYxh.yname"/> </td>
        <td> <s:property value="sex"/> </td>
        <td> <s:property  value="birthdate"/> </td>
        <td> <s:property value="password"/> </td>


        </tr>
    </s:iterator>
    <tr>
        <s:submit class="btn btn-success" value="保存修改"/>
    </tr>
</table>
</s:form>
</body>
</html>