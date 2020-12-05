package com.javaWeb.web;

import com.javaWeb.pojo.Book;
import com.javaWeb.pojo.Cart;
import com.javaWeb.pojo.CartItem;
import com.javaWeb.service.BookService;
import com.javaWeb.service.impl.BookServiceImpl;
import com.javaWeb.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CartServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    //添加图书信息到购物车
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 商品编号
        int id = WebUtil.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成为CartItem商品项

        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addCart(cartItem);
        System.out.println(cart);
        // Referer：Http中的协议头，它把请求发起时，浏览器中的地址返回给服务器
//        System.out.println("请求头Referer的值：" + req.getHeader("Referer"));
        //最后一个添加的商品名称
        req.getSession().setAttribute("lastName", cartItem.getName());
        //重定向回原来商品所在的地址页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    //从购物车删除商品项
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取商品编号
        int id = WebUtil.parseInt(req.getParameter("id"), 0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            // 删除 了购物车商品项
            cart.deleteCart(id);
            // 重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    //清空购物车
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //1.获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            //清空购物车
            cart.clear();
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    //修改购物车某本图书数量
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取请求的参数 商品编号 、商品数量
        int id = WebUtil.parseInt(req.getParameter("id"),0);
        int count = WebUtil.parseInt(req.getParameter("count"), 1);
        //获取Cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            //修改商品数量
            cart.updateCart(id,count);
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }


}
