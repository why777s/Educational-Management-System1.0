<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/5/11
  Time: 16:17
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
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">    <title>开放选课</title>

    <script>
        <s:if test="#request.message!=null">
            alert("<s:property value="#request.message"/>");
        </s:if>
    </script>
</head>
<body>

<s:form method="POST"  action="woxiangheyidiandian.action">

    <div class="control-group">
        <label class="control-label" for="红茶玛奇朵">
            <p>如果要开放选课，请输入“开放选课”</p>
            <p>如果要关闭选课，请输入“关闭选课”</p>
        </label>
        <div class="controls">
            <input id="红茶玛奇朵" name="setopen" type="text"/>
        </div>
    </div>
    <input type="submit" class="btn btn-danger" value="确认修改"/>
    <%--<s:submit value="确定修改"/>--%>
</s:form>
</body>
</html>
