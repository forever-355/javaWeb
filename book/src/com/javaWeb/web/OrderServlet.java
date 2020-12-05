package com.javaWeb.web;


import com.javaWeb.pojo.Cart;
import com.javaWeb.pojo.User;
import com.javaWeb.service.OrderService;
import com.javaWeb.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {


    //创建订单，需要购物车对象和用户id
    private OrderService orderService = new OrderServiceImpl();
    protected void creatOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取Cart购物车对象,之前加入购物车是存放在Session域中的
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取Userid
        User loginUser = (User) req.getSession().getAttribute("user");

        //未登录时，不能去结账，跳转到登录页面
        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        int userId = loginUser.getId();
        //调用orderService.createOrder(Cart,Userid)生成订单
        String orderId = orderService.createOrder(cart, userId);
        //把orderId保存到session域中，在结算页面显示订单号
        req.getSession().setAttribute("orderId",orderId);
        //请求转发到/pages/cart/checkout.jsp
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
