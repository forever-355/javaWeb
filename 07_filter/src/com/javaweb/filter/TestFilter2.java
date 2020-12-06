package com.javaweb.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TestFiletr2前置代码");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("TestFiletr2后置代码");
    }

    @Override
    public void destroy() {

    }
}
