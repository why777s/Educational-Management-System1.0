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
    <title>成绩录入</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="<%=basePath%>/bootstrap/js/bootstrap.js"></script>
    <link href="<%=basePath%>/bootstrap/css/bootstrap.css" rel="stylesheet">
    <%--弹窗报错--%>
    <%--<script>--%>
        <%--<s:if test="#request.message1!=null">--%>
        <%--alert("<s:property value="#request.message1"/>")--%>
        <%--</s:if>--%>
    <%--</script>--%>
</head>
<body >
<div class="dropdown">
    <button class="btn btn-default" type="button"  data-toggle="dropdown">请选择登分课程<span class="caret"></span></button>
    <ul class="dropdown-menu">
        <s:iterator value="#request.openCourseList" id="c">
            <li>
                <a href="<s:url action="turn_TC">
                            <s:param name="tc_downmenu_cid"  value="%{cid}"/>
                    </s:url>">
                   <s:property value="#c.courseByCid.cname"/>
                    <%--<s:property value="#c.courseByCid.cname"/>--%>
                </a>
            </li>
        </s:iterator>
    </ul>
</div>
<hr>
<s:form action="update_dfbl" theme="simple" method="POST">
    <span class="label">成绩比例(平时成绩/总评成绩)</span>
    <s:textfield name="dfbl" cssStyle="width:50px" maxlength="4" value="%{dfbl_Old}" />
    <button class="btn btn-success">修改</button>
</s:form>
<s:form action="TC_df" theme="simple" method="POST">
    <%--计分比例--%>
    <table class="table table-hover table-bordered">
        <tr>
            <th>学号</th>
            <th>学生姓名</th>
            <th>课程号</th>
            <th>课程名</th>
            <th>平时成绩</th>
            <th>考试成绩</th>
            <th>总评成绩</th>
        </tr>
        <s:iterator status="st" value="tc_scList" id="tc">
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
            <td> <s:property value="#tc.sid"/> </td>
            <td> <s:property value="#tc.studentBySid.sname"/> </td>
            <td> <s:property value="#tc.cid"/> </td>
            <td> <s:property value="#tc.courseByCid.cname"/> </td>
            <%--name是向action传list，value是输出--%>
            <td><s:textfield cssStyle="width:50px" maxlength="4" name="pscj_list[%{#st.index}]" value="%{pscj}"/></td>
            <td><s:textfield cssStyle="width:50px" maxlength="4" name="kscj_list[%{#st.index}]" value="%{kscj}"/></td>
            <td><s:property value="#tc.zpcj"/></td>
            </tr>
        </s:iterator>
    </table>
    <button class="btn btn-success" type="submit">登分保存</button>
</s:form>

</body>
</html>