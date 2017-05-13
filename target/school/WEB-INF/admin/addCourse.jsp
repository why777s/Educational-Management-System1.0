<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/5/12
  Time: 02:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        <s:if test="#request.message!=null">
        alert("<s:property value="#request.message"/>");
        </s:if>
    </script>
    <title>Title</title>
</head>
<body>
<s:form theme="simple" action="addaddCourse">
    课程号<s:textfield name="cid"  />
    </br>    </br>


    课程名:<s:textfield name="cname" />
    </br>    </br>


    学院:<s:textfield name="ccredit"/>
    </br>    </br>


    院系号:<s:textfield name="yxh"/>
    </br>    </br>


    <s:submit value="提交"/>
</s:form>

</body>
</html>
