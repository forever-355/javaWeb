package com.javaweb.filter.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.getRequestURI()     获取请求的资源路径
        System.out.println("URI:"+req.getRequestURI());
        //2.getRequestURL()     获取请求的统一资源定位符(绝对路径)
        System.out.println("URL:"+req.getRequestURL());
        //3.getRemoteHost()     获取客户端的ip地址
        System.out.println("ip地址:"+req.getRemoteHost());
        //4.getHeader()         获取请求头
        System.out.println("请头 User-Agent："+req.getHeader("User-Agent"));

        //6.getParameterValues()获取请求的参数(多个值的时候使用)
        //7.getMethod()         获取请求的方式GET或POST
        System.out.println("请求的方式为："+req.getMethod());
        //8.setAttribute()      设置域数据
        //9.getAttribute()      获取域数据
    }
}
