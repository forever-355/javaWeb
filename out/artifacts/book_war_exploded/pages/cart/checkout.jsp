<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>

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
			<span class="wel_word">结算</span>
		<%--	登录成功后的静态替换页面	--%>
		<%@ include file="/pages/commn/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
		
		<h1>您的订单已支付，订单号为: ${sessionScope.orderId}</h1>
		
	
	</div>

	<%--	静态包含，页脚部分--%>
	<%@include file="/pages/commn/footer.jsp"%>
</body>
</html>