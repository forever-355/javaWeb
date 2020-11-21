package com.javaWeb.servlet.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    @Override
    //contextInitialized  Initialized:已初始化
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象被初始化了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了");
    }
}
