package com.javaweb.filter.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需要修改字符集编码，不然浏览器乱码,有两个方法
        //--1--
        //1.修改idea字符集
//        resp.setCharacterEncoding("UTF-8");
        //2.修改浏览器字符集
//        resp.setHeader("Content-Type","text/html;charset=utf-8");

        //--2--
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("连接成功");
    }
}
