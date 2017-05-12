<%@ page import="Dao.impl.CourseDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Course" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wangzhaojun
  Date: 2017/4/18
  Time: 22:31
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

        <%--function activeSave() {--%>
<%--//            alert(s);--%>
<%--//            var tb = document.getElementById("tb1");--%>
<%--//            var v = tb.rows(1).cells(1);--%>
<%--//            alert("aaa");--%>
<%--//            v.innerHTML = "<input type='text' value='"+v.innerText+"'/>";--%>
            <%--document.getElementById("btn1").className="btn btn-info";--%>
            <%--document.getElementById("btn1").href=--%>
                <%--"<s:url action="xiugaixuefen"><s:param name="jieshoudecid" value="%{cid}"/><s:param name="jieshoudecname" value="%{newcname}"/></s:url>";--%>
<%--//                这个不知道为什么只能写在一行，分多行写就不行=-=贼烦心态蹦了--%>
        <%--}--%>
        <%----%>


    </script>



    <title>课程</title>
</head>
<body onload="init()">
<s:form theme="simple" action="xiugaixuefen"  method="POST" >
<table id="tb1" class="table table-hover table-bordered" >
    <tr>
        <th>课程号:</th>
        <th>课程名</th>
        <th>学分</th>
        <th>院系名</th>
    </tr>
    <s:iterator value="courseList" status="st">
        <%--<s:hidden name="jieshoudexuhao" value="%{#st.index}"/>--%>
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
        <%--[%{#st.index}]--%>
        <td> <s:property value="cid"/>
            <s:hidden name="jieshoudecid" value="%{cid}"/>
            <%--<s:hidden name="jieshoudexuyao" value="2"/>--%>
        </td>
        <td> <s:textfield name="jieshoudecname" cssStyle="width:100px"  maxlength="12" value="%{cname}"/>
            <%--<s:hidden id="wohenfan" name="jieshoudecname" value="courseList[%{#st.index}].cname"/>--%>
        </td>
        <%--<td> <s:property value="cname"/> </td>--%>
        <td> <s:property value="ccredit"/> </td>
        <td> <s:property value="collegeByYxh.yname"/> </td>
            <%--<a id="btn1" type="submit" href="xiugaixuefen" class="btn btn-success">--%>
                <%--<s:url action="xiugaixuefen">--%>
                    <%--<s:param name="jieshoudecid" value="%{cid}"/>--%>
                    <%--<s:param name="jieshoudecname" value="%{cname}" />--%>
                    <%--<s:param name="jieshoudexuhao" value="%{#st.index}"/>--%>
                <%--</s:url>">--%>
                <%--保存--%>
            <%--</a>--%>
        </tr>
    </s:iterator>
    <hr class="hr20">
    <tr>
        <s:submit value="保存" class="btn btn-success"/>
    </tr>
</table>
</s:form>

</body>
</html>
