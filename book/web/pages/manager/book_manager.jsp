<%--
  Created by IntelliJ IDEA.
  User: 清风慕竹
  Date: 2020-11-27
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

	<%--   静态包含的 base标签，css样式，js     --%>
	<%@ include file="/pages/commn/head.jsp"%>

	<script type="text/javascript">
		$(function () {
			// 给删除的a标签绑定单击事件，用于删除时跳窗确认删除
			$("a.deleteClass").click(function () {
				// 在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象。
				//   confirm是确认提示框函数
				return confirm("你确定要删除图书编号为： " + $(this).parent().parent().find("td:first").text() + "的图书吗?");
				// return false// 阻止元素的默认行为===不提交请求
			});
		});
	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>

		<%--			静态包含，manager目录下的图书菜单--%>
		<%@include file="/pages/commn/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>图书ID</td>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>

			<c:forEach items="${requestScope.books}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="pages/manager/book_edit.jsp">修改</a></td>
<%--					class="deleteClass"绑定一个单击事件，跳窗确认删除的信息--%>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}">删除</a></td>
				</tr>
			</c:forEach>


			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
	</div>

	<%--	静态包含，页脚部分--%>
	<%@include file="/pages/commn/footer.jsp"%>
</body>
</html>