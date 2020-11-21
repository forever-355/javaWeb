package com.javaweb.filter.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if("abc".equals(username) && "123456".equals(password)){
            req.getSession().setAttribute("user",username);
            resp.getWriter().write("登陆成功");
        } else{
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
