<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

	<%--   静态包含的 base标签，css样式，js     --%>
	<%@ include file="/pages/commn/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("a.deleteItem").click(function () {
				//删除购物车图书单击事件
				return confirm("您确定要删除书名为： " + $(this).parent().parent().find("td").eq(0).text() + "的图书吗?");
			});
			$("#claerItem").click(function () {
				//清空购物车事件
				return confirm("您确定要清空购物车吗？")
			});
			//给购物车数据输入框绑定onchange内容发生改变事件
			$(".updateCount").change(function () {
				//获取商品名称
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr('bookId');
				//获取商品数量
				var count = this.value;
				if ( confirm("您确定要将图书" + name + "数量修改为：" + count + " 吗?") ) {
					//发起请求。给服务器保存修改
					location.href = "http://localhost:8080/book/cartServlet?action=updateCount&count="+count+"&id="+id;
				} else {
					// defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值。
					this.value = this.defaultValue;
				}
			});
		});
	</script>

</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%--	登录成功后的静态替换页面	--%>
		<%@ include file="/pages/commn/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${empty sessionScope.cart.items}">
				<%--如果购物车空的情况--%>
				<tr>
					<td colspan="5"><a href="index.jsp">亲，当前购物车为空, 点击即可去浏览商品！！！</a> </td>
				</tr>
			</c:if>

			<c:forEach items="${sessionScope.cart.items}" var="entry">
				<tr>
					<td>${entry.value.name}</td>
					<td>
						<input class="updateCount" style="width: 80px;"
							   bookId="${entry.value.id}"
							   type="text" value="${entry.value.count}">
					</td>
					<td>${entry.value.price}</td>
					<td>${entry.value.totalPrice}</td>
					<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
				</tr>
			</c:forEach>



		</table>
		<c:if test="${not empty sessionScope.cart.items}">

		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a id="claerItem" href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=creatOrder">去结账</a></span>
		</div>

		</c:if>
	
	</div>

	<%--	静态包含，页脚部分--%>
	<%@include file="/pages/commn/footer.jsp"%>
</body>
</html>