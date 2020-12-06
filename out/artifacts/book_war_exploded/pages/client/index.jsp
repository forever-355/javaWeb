<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>书店首页</title>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >


</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书店</span>
			<div>
<%--				如果还没有登录，显示登录和注册页面--%>
				<c:if test="${empty sessionScope.user}">
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/regist.jsp">注册</a>
				</c:if>

<%--				如果已经注册，显示欢迎登录信息--%>
				<c:if test="${not empty sessionScope.user}">
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临三岛书店</span>
					<a href="pages/order/order.jsp">我的订单</a>
					<a href="userServlet?action=logOut">注销</a>&nbsp;&nbsp;&nbsp;

				</c:if>

				&nbsp;&nbsp;
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="clientBookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice">
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
						<input id="max" type="text" name="max" value="${param.max}"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有4件商品</span>
				<div>
					您刚刚将<span style="color: red">《JavaWeb从入门到精通》</span>加入到了购物车中
				</div>
			</div>

			<c:forEach items="${requestScope.page.items}" var="book">

				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.img_path}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>
						<div class="book_add">
							<button onclick="javascript:window.location.href='http://localhost:8080/book/cartServlet?action=addItem&id=${book.id}'">加入购物车</button>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>

<%--        分页开始--%>
        <div id="page_nav">
            <c:if test="${requestScope.page.pageNo > 1}">
                <a href="${requestScope.page.url}&pageNo=1">首页</a>
                <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
            </c:if>

            <a href="#">${requestScope.page.pageNo-1}</a>
            【${requestScope.page.pageNo}】
            <a href="#">${requestScope.page.pageNo+1}</a>
            <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
                <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
                <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
            </c:if>

            共${requestScope.page.pageTotal}页，
            ${requestScope.page.pageTotalCount}条记录
            到第<input value="4" name="pn" id="pn_input"/>页
            <input id="searchPaheBtn" type="button" value="确定">
        </div>
<%--	分页结束--%>

	</div>

	
	<%@include file="/pages/commn/footer.jsp"%>
</body>
</html>