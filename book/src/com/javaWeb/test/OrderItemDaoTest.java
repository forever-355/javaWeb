package com.javaWeb.test;

import com.javaWeb.dao.OrderItemDao;
import com.javaWeb.dao.impl.OrderItemDaoImpl;
import com.javaWeb.pojo.OrderItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem(){
        orderItemDao.saveOrderItem(new OrderItem(null,"《深入理解计算机系统》",1,104.9,104.9,"1234567890"));
    }


}