package com.javaWeb.test;

import com.javaWeb.pojo.Cart;
import com.javaWeb.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addCart() {
        Cart cart = new Cart();
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,new BigDecimal(99),new BigDecimal(99)));
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,new BigDecimal(99),new BigDecimal(99)));
        cart.addCart(new CartItem(2,"《深入理解计算机系统》",1,new BigDecimal(20),new BigDecimal(20)));
        System.out.println(cart);
    }

    @Test
    public void deleteCart() {
        Cart cart = new Cart();

        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,new BigDecimal(99),new BigDecimal(99)));
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,new BigDecimal(99),new BigDecimal(99)));
        cart.addCart(new CartItem(2,"《深入理解计算机系统》",1,new BigDecimal(20),new BigDecimal(20)));
        cart.deleteCart(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,new BigDecimal(99),new BigDecimal(99)));
        cart.addCart(new CartItem(2,"《深入理解计算机系统》",1,new BigDecimal(20),new BigDecimal(20)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCart() {
        Cart cart = new Cart();
        cart.addCart(new CartItem(1,"《javaWeb从入门到精通》",1,new BigDecimal(99),new BigDecimal(99)));

        //修改数量到10
        cart.updateCart(1,10);
        System.out.println(cart);
    }
}