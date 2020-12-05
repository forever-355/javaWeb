package com.javaWeb.service.impl;


import com.javaWeb.dao.BookDao;
import com.javaWeb.dao.OrderDao;
import com.javaWeb.dao.OrderItemDao;
import com.javaWeb.dao.impl.BookDaoImpl;
import com.javaWeb.dao.impl.OrderDaoImpl;
import com.javaWeb.dao.impl.OrderItemDaoImpl;
import com.javaWeb.pojo.*;
import com.javaWeb.service.OrderService;

import java.sql.Time;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    public String createOrder(Cart cart, Integer userId){

        //订单号要具有唯一性，不能出现相同的订单号
        //所以引出时间戳
        String orderId = System.currentTimeMillis()+""+userId;
        //创建订单的时候，订单价格就是购物车中的总价格
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //创建订单
        orderDao.saveOrder(order);
        //遍历购物车中的商品项转换为订单中的订单项，保存订单到数据库
        for (Map.Entry<Integer,CartItem>entry:cart.getItems().entrySet()) {
            //获取购物车中的商品项
            CartItem cartItem = entry.getValue();
            //把购物车商品项转换为订单中的订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //创建订单
            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales( book.getSales() + cartItem.getCount() );
            book.setStock( book.getStock() - cartItem.getCount() );
            bookDao.updateBook(book);

        }
        //转换完毕，清空购物车
        cart.clear();
        return orderId;

    }
}
