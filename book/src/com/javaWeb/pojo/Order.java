package com.javaWeb.pojo;

import java.util.Date;


//订单类（一个订单包含多件商品）
public class Order {
    private String orderId;
    private Date datatime;
    private double price;
    //订单状态：0--未发货  1--已发货   2--已签收
    private int status;
    private int userId;

    public Order(String orderId, Date datatime, double price, int status, int userId) {
        this.orderId = orderId;
        this.datatime = datatime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderDao{" +
                "orderId='" + orderId + '\'' +
                ", datatime=" + datatime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
