package com.javaWeb.dao.impl;

import com.javaWeb.dao.OrderItemDao;
import com.javaWeb.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    //保存商品项进某个订单中
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into table_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());

    }
}
