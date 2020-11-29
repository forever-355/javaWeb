package com.javaweb.filter.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//请求从定位
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        System.out.println("Response1 到此一游");
        //从当前跳到下面的新地址
        //1.方法一
        resp.setStatus(302);
        resp.setHeader("Location","http://localhost:8085/03_servlet2/response2");

        //方法二
//        resp.sendRedirect("http://localhost:8085/03_servlet2/response2");
    }
}
