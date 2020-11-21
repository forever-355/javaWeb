<%@ page import="java.util.ArrayList" %>
<%@ page import="com.javaWeb.servlet.projo.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 清风慕竹
  Date: 2020-11-14
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生信息表</title>
    <style type="text/css">
        table{
            border:1px pink solid;
            width: 550px;
            border-collapse: collapse;
        }
        td,th{
            border:1px pink solid;
        }
    </style>
</head>
<body>
    <%
        ArrayList<Student> student1 = (ArrayList<Student>)    request.getAttribute("stuList");
    %>
<table align="center">
        <tr align="center">
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
    <%for(Student student:student1){%>
        <tr align="center">
            <td><%=student.getName()%></td>
            <td><%=student.getSex()%></td>
            <td><%=student.getAge()%></td>
            <td><%=student.getTel()%></td>
            <td>删除、修改</td>
        </tr>
    <%}%>
</table>
</body>
</html>
