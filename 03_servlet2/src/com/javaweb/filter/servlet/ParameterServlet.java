package com.javaweb.filter.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----------doGet------------");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hobby = req.getParameter("hobby");

        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("兴趣爱好："+ Arrays.asList(hobby));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*post方法中文会有乱码
        * 设置字符集为utf-8
        * */
        req.setCharacterEncoding("utf-8");
        System.out.println("-------------doPost------------");
        // 获取请求参数
        String username1 = req.getParameter("username");
        String password1 = req.getParameter("password");
        String hobby1 = req.getParameter("hobby");


        System.out.println("用户名：" + username1);
        System.out.println("密码：" + password1);
        System.out.println("兴趣爱好：" + Arrays.asList(hobby1));
    }
}
