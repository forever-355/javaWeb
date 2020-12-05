package com.javaWeb.dao.impl;

import com.javaWeb.dao.OrderDao;
import com.javaWeb.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    //保存订单至订单表
    public int saveOrder(Order order) {
        String sql = "insert into table_order(order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getDatatime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
