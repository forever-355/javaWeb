<%--
  Created by IntelliJ IDEA.
  User: 清风慕竹
  Date: 2020-11-27
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>

	<%--   静态包含的 base标签，css样式，js     --%>
	<%@ include file="/pages/commn/head.jsp"%>

	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">后台管理系统</span>

		<%--			静态包含，manager目录下的图书菜单--%>
		<%@include file="/pages/commn/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>

	<%--	静态包含，页脚部分--%>
	<%@include file="/pages/commn/footer.jsp"%>
</body>
</html>