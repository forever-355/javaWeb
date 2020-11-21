<%--
  Created by IntelliJ IDEA.
  User: 清风慕竹
  Date: 2020-11-13
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<head>
    <title>Title</title>
</head>
    头部信息</br>
    主题内容</br>

<%--有静态包含和动态包含两种，功能是把footer.jsp的内容包含进了main.jsp中来--%>
<%--1.静态包含--%>
<%--    <%@include file=""%>   --%>
<%--    <%@include file="footer.jsp"%>--%>

<%--2.动态包含--%>
    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value = "aaa"/>
        <jsp:param name="password" value = "root"/>

    </jsp:include>


</body>
</html>
