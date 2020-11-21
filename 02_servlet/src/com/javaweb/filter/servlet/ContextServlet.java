package com.javaweb.filter.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println("context-param参数的username值是:"+username);
        String password = context.getInitParameter("password");
        System.out.println("context-param参数的password值是:"+password);
//        2.获取当前的工程路径，格式：/工程路径
        System.out.println("当前的工程路径为："+context.getContextPath());
//        3.获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("工程部署的路径为："+context.getRealPath("/"));
        System.out.println("工程下css的绝对路径是："+context.getRealPath("/css"));
        System.out.println("工程下imgs的绝对路径是："+context.getRealPath("/imgs"));
        System.out.println("工程下imgs/1.jpg的文件的绝对路径是："+context.getRealPath("/imgs/1.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
