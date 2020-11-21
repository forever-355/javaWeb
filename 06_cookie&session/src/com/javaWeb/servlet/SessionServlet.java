package com.javaWeb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    //1.创建或获取session
    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取session对象
        HttpSession session = req.getSession();
        //判断session是否为新
        boolean isNew = session.isNew();
        //获取session的唯一id
        String id = session.getId();
        resp.getWriter().write("session的id是："+id+"</br>");
        resp.getWriter().write("获取的session对象是："+session+"</br>");
        resp.getWriter().write("session对象是否为新："+isNew+"</br>");
    }

    /**
     * 2.向seesion数据域中存放和获取数据
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("session中key1的数据值设置成功！");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("session中key1的数据值是：" + key1);
    }
    
    //3.session生命周期控制
    protected void defaultTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //session的默认超时时长，单位秒
        //可在web.xml重新配置时长的值
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的默认超时时长为：" + maxInactiveInterval + "s");
    }

    //4.修改单个的默认值
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取session对象
        HttpSession session = req.getSession();
        //设置当前session 3秒后超时
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前session已经设置为3秒后超时");
    }

    //5.session马上销毁
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.getWriter().write("session已经销毁了！");
    }
}

