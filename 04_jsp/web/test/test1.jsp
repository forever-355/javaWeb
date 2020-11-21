<%--
  Created by IntelliJ IDEA.
  User: 清风慕竹
  Date: 2020-11-13
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
    <style type="text/css">
        table{
            width: 700px;
        }
    </style>
</head>
<body>
<h3>乘法口诀表</h3>
<table>
<%for(int i=1;i<=9;i++){%>
    <tr>
        <%for(int j=1;j<=i;j++){%>
        <td><%=j + "x" + i + "=" + (i*j)%></td>
        <%}%>
    </tr>
    <%}%>
</table>
</body>
</html>
