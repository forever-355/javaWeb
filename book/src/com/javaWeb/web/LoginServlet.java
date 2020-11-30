package com.javaWeb.web;

import com.javaWeb.pojo.User;
import com.javaWeb.service.UserService;
import com.javaWeb.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数(用户名和密码)
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.调用userService.login()登录处理业务
        User loginUser = userService.Login(new User(null, username, password, null));
        if (loginUser == null) {  //如果等于null,说明登录失败
            //提示用户名或密码错误
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            System.out.println("用户名或密码错误！");
        } else {
            //登录成功
            //跳到成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
