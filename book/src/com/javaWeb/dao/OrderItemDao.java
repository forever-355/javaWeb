package com.javaWeb.dao;

import com.javaWeb.pojo.OrderItem;

public interface OrderItemDao {

    //保存商品项至某个订单中
    public int saveOrderItem(OrderItem orderItem);
}
