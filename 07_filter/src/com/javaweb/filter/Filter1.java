package com.javaweb.filter;

import javax.servlet.*;
import java.io.IOException;
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(" Filter1的前置代码!");
        System.out.println(" Filter1的线程: " + Thread.currentThread().getName());
        System.out.println(" Filter1 " + req.getParameter("username"));
        req.setAttribute("key1", "value1");
        chain.doFilter(req, resp);
        System.out.println(" Filter1的后置代码!");



    }

    public void init(FilterConfig config) throws ServletException {

    }

}