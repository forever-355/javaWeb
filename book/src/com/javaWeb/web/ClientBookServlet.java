package com.javaWeb.web;

import com.javaWeb.pojo.Book;
import com.javaWeb.pojo.Page;
import com.javaWeb.pojo.User;
import com.javaWeb.service.BookService;
import com.javaWeb.service.impl.BookServiceImpl;
import com.javaWeb.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//首页
public class ClientBookServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();
    //分页
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtil.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtil.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        //设置分页跳转地址 前台
        page.setUrl("?action=page");
        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("pages/client/index.jsp").forward(req,resp);
    }


    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtil.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtil.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtil.parseInt(req.getParameter("min"),0);
        int max = WebUtil.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);

        //设置分页跳转地址 前台
        page.setUrl("clientBookServlet?action=pageByPrice");
        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到/pages/client/index.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }


}


