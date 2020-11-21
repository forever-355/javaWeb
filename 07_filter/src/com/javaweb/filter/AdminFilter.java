package com.javaweb.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

/*
* doFilter方法
* 专门用于拦截请求。可以做权限调查
*
* */

    public AdminFilter(){
        System.out.println("1.filer的构造器方法");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.filer的初始化方法");
        //1.获取Filter的名称filter-name的内容
        System.out.println("filter的name为：" + filterConfig.getFilterName());
        //2.获取在filter中配置的init-param初始化参数
        System.out.println("获取的username的值是："+filterConfig.getInitParameter("username"));
        System.out.println("获取的url的值是："+filterConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.filter 的过滤方法");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        //如果等于null，说明还没有登录
        //弹出一个登录页面
        if(user == null){
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        } else{
            //让程序继续往下访问用户的目标资源
            //已登陆
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

        System.out.println("4.filer的销毁方法");
    }
}
