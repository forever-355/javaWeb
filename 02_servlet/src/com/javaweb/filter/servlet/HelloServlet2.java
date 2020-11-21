package com.javaweb.filter.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {

    //重写init方法
    @Override
    public void init(ServletConfig config) throws ServletException {
        //重写init方法后必须super.init(config)，否则打印不出username和url的值
        super.init(config);
        System.out.println("重写了init初始化方法，做了一些工作");
    }

    /*
    * doGet()方法在get请求时调用*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("HelloServlet2 的doGet方法");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
//      2.获取初始化参数init-param
        System.out.println("初始化参数username的值是："+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是："+servletConfig.getInitParameter("url"));

    }

    /*
    * doPost()方法在post请求时调用*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("HelloServlet2 的doPost方法");
    }
}
