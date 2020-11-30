package com.javaWeb.web;

import com.javaWeb.pojo.Book;
import com.javaWeb.service.BookService;
import com.javaWeb.service.impl.BookServiceImpl;
import com.javaWeb.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    //web页面添加图书
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数，封装称为book对象
        Book book = WebUtil.copyParmToBean(req.getParameterMap(), new Book());
        //2.调用bookService.add方法添加图书
        bookService.addBook(book);
        //3.跳到图示列表页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=select");
    }

    //web页面删除图书
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数id，图书编号
        String id = req.getParameter("id");
        //把id的string类型转换成Interger类型
        int newId = Integer.parseInt(id);
        //2.调用bookService.delete方法删除图书
        bookService.deleteBook(newId);
        //3.跳到图示列表页面：/manager/bookServlet?action=select
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=select");
    }

    //web更改图书信息
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //web页面查看图书
    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到Request域中
        req.setAttribute("books",books);
        //3、请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
