package com.javaWeb.dao;

import com.javaWeb.pojo.Order;

//订单Dao接口
public interface OrderDao {

    //可多个订单保存至订单表
    public int saveOrder(Order order);
}
