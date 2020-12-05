package com.javaWeb.test;

import com.javaWeb.pojo.Cart;
import com.javaWeb.pojo.CartItem;
import com.javaWeb.service.OrderService;
import com.javaWeb.service.impl.OrderServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder(){
        Cart cart = new Cart();
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,99,99));
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,99,99));
        cart.addCart(new CartItem(2,"《深入理解计算机系统》",1,20,20));

        OrderService orderService = new OrderServiceImpl();
        System.out.println("订单号是：" + orderService.createOrder(cart,2));
    }

}