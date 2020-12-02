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
				return confirm("你确定要删除书名为： " + $(this).parent().parent().find("td").eq(1).text() + "的图书吗?");
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

			<c:forEach items="${requestScope.page.items}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
<%--					class="deleteClass"绑定一个单击事件，跳窗确认删除的信息--%>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
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
				<td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>	
		</table>
		<div id="page_nav">
            <c:if test="${requestScope.page.pageNo > 1}">
                <a href="manager/bookServlet?action=page&pageNo=1">首页</a>
                <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
            </c:if>

			<a href="#">${requestScope.page.pageNo-1}</a>
			【${requestScope.page.pageNo}】
			<a href="#">${requestScope.page.pageNo+1}</a>
            <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
                <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
                <a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
            </c:if>

			共${requestScope.page.pageTotal}页，
            ${requestScope.page.pageTotalCount}条记录
            到第<input value="4" name="pn" id="pn_input"/>页
			<input id="searchPaheBtn" type="button" value="确定">

<%--            <script type="text/javascript">--%>

<%--                $(function () {--%>
<%--                    // 跳到指定的页码--%>
<%--                    $("#searchPageBtn").click(function () {--%>
<%--                        var pageNo = $("#pn_input").val();--%>
<%--                        &lt;%&ndash;var pageTotal = ${requestScope.page.pageTotal};&ndash;%&gt;--%>
<%--                        &lt;%&ndash;alert(pageTotal);&ndash;%&gt;--%>
<%--                        // javaScript语言中提供了一个location地址栏对象--%>
<%--                        // 它有一个属性叫href.它可以获取浏览器地址栏中的地址--%>
<%--                        // href属性可读，可写--%>
<%--                        location.href = "${pageScope.basePath}${ requestScope.page.url }&pageNo=" + pageNo;--%>
<%--                    });--%>
<%--                });--%>
<%--            </script>--%>

		</div>

	</div>

	<%--	静态包含，页脚部分--%>
	<%@include file="/pages/commn/footer.jsp"%>
</body>
</html>