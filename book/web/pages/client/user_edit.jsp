<%--
  Created by IntelliJ IDEA.
  User: 清风慕竹
  Date: 2020-12-03
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑用户</title>

    <%--   静态包含的 base标签，css样式，js     --%>
    <%@ include file="/pages/commn/head.jsp"%>

    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">编辑用户</span>


</div>

<div id="main">

    <form action="userServlet" method="get">
        <input type="hidden" name="action" value="update" />
<%--        <input type="hidden" name="id" value="${ requestScope.user.id }" />--%>
        <table>
            <tr>
                <td>用户名</td>
                <td>密码</td>
                <td>邮箱</td>
            </tr>
            <tr>
                <td ><input name="username" type="text" value="${sessionScope.user.username}"/></td>
                <td><input name="password" type="text" value="${sessionScope.user.password}"/></td>
                <td><input name="email" type="text" value="${sessionScope.user.email}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>

</div>

<%--	静态包含，页脚部分--%>
<%@include file="/pages/commn/footer.jsp"%>
</body>
</html>
