package com.javaWeb.service;

import com.javaWeb.pojo.Cart;

public interface OrderService {

    //创建订单时，参数为用户的购物车和用户编号
    public String createOrder(Cart cart, Integer userId);
}
