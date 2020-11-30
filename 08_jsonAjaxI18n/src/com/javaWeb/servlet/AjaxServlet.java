package com.javaWeb.servlet;

import com.google.gson.Gson;
import com.javaWeb.proj.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {
    protected void JavaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajax请求过来了");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Person person = new Person(1,"三岛");

        //创建Gson实例化对象
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }
}
