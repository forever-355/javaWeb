package com.javaWeb.test;

import com.javaWeb.pojo.Cart;
import com.javaWeb.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    //测试添加图书进购物车
    public void addCart() {
        Cart cart = new Cart();
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,99,99));
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,99,99));
        cart.addCart(new CartItem(2,"《深入理解计算机系统》",1,20,20));
        System.out.println(cart);
    }

    @Test
    //测试删除购物车中图书
    public void deleteCart() {
        Cart cart = new Cart();

        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,99,99));
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,99,99));
        cart.addCart(new CartItem(2,"《深入理解计算机系统》",1,20,20));
        cart.deleteCart(1);
        System.out.println(cart);
    }

    @Test
    //测试清空购物车
    public void clear() {
        Cart cart = new Cart();
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,99,99));
        cart.addCart(new CartItem(2,"《深入理解计算机系统》",1,20,20));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    //测试通过图书id更新购物车
    public void updateCart() {
        Cart cart = new Cart();
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,99,99));

        //修改数量到10
        cart.updateCart(1,10);
        System.out.println(cart);
    }
}