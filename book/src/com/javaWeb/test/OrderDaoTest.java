package com.javaWeb.test;

import com.javaWeb.dao.OrderDao;
import com.javaWeb.dao.impl.OrderDaoImpl;
import com.javaWeb.pojo.Order;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

   private OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder(){
        orderDao.saveOrder(new Order("1234567890",new Date(),20,0,2));
    }

}