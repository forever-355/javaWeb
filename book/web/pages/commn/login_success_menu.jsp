<%--
  Created by IntelliJ IDEA.
  User: 清风慕竹
  Date: 2020-11-27
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function () {
        // 给注销的a标签绑定单击事件，用于注销时跳窗确认注销
        $("a.deleteClass").click(function () {
            // 在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象。
            //   confirm是确认提示框函数
            return confirm("您确定要注销吗?");
        });
    });
</script>

<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临三岛书店</span>
    <a href="pages/order/order.jsp" target="_self">我的订单</a>
<%--    <a href="userServlet?action=logOut">注销</a>&nbsp;&nbsp;--%>
    <a class="deleteClass" href="userServlet?action=delete&id=${user.id}" >注销</a>
    <a href="pages/client/user_edit.jsp" target="_self">修改</a>
    <a href="index.jsp" target="_self">返回</a>
</div>

