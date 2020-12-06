package com.javaweb.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TestFiletr1前置代码");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("TestFiletr1后置代码");
    }

    @Override
    public void destroy() {

    }
}
