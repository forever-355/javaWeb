package com.javaWeb.servlet;

import com.javaWeb.servlet.Utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {
    //5.path路径
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1","path1");
        //req.getContextPath()得到工程路径
        cookie.setPath(req.getContextPath() + "/abc"); //——>>>工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");
    }

    //4.生命控制
    //默认生存时间
    protected void defauleLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defauleLift","defauleLife");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    //立即删除
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.找到要删除的对象
        Cookie cookie = CookieUtils.findCookie("defauleLift",req.getCookies());
        if (cookie != null){
            //2.设置setMaxAge(0)
            cookie.setMaxAge(0);
            //3.调用resp.addCookie(cookie)
            resp.addCookie(cookie);
            resp.getWriter().write("defauleLife的cookie已经被删除了！");
        }
    }

    //设置存活时间3600秒
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600","life3600");
        cookie.setMaxAge(60 * 60);
        resp.addCookie(cookie);
        resp.getWriter().write("life3600已经被创建了");
    }

    //    3.更改cookie值
//    方案一：
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key1","newValue1");
        resp.addCookie(cookie);
        resp.getWriter().write("key1值修改成功！");
    }

    //方案二：
//    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //1.先查找需要修改的cookie对象
//        Cookie cookie = CookieUtils.findCookie("key2",req.getCookies());
//        if(cookie != null){
//            //2.调用setValue方法设置新的value值
//            cookie.setValue("newValue2");
//            //3.调用response.addCookie()通知客户端修改
//            resp.addCookie(cookie);
//            resp.getWriter().write("key2值修改成功:"+cookie.getName()+"："+cookie.getValue());
//        }
//    }

    //2.获取cookie
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie iWantCookie = CookieUtils.findCookie("key1",cookies);
        for(Cookie cookie:cookies){
            //getName 方法返回Cookie的key(名)
            //getValue 方法返回Cookie的value值
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() +"]</br>");
        }

        if(iWantCookie != null){
            resp.getWriter().write("找到的Cookie："+iWantCookie.getName()+ "=" + iWantCookie.getValue());
        }
    }

    //1.创建cookie
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建cookie对象
        Cookie cookie1 = new Cookie("key1","value1");
        Cookie cookie2 = new Cookie("key2","value2");
        Cookie cookie3 = new Cookie("key3","value3");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
        resp.getWriter().write("Cookie创建成功！");
    }
}
