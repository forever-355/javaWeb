package com.javaWeb.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*购物车类*/
public class Cart {

//    private Integer totalCount; //书本数
//    private Double totalPrice; //总金额
    //key 商品编号，value 商品信息
    //购物车中的商品项
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    //添加商品进购物车
    public void addCart(CartItem cartItem){
        //先查看购物车中是否有添加的商品，若有，数量累加，总金额更新
        //若没有添加过，则直接添加进list集合

        //获取添加商品的id
        //创建一个待添加商品项对象
        //cartItem 待添加商品项，item：已添加商品项， items：购物车商品项
        CartItem item = items.get(cartItem.getId());
        if(item == null){
            //之前没有添加过，直接添加
            items.put(cartItem.getId(),cartItem);
        } else{
            //之前添加过
            item.setCount( item.getCount() + 1 );
            item.setTotalPrice( item.getPrice() * item.getCount() );
        }
    }

    //从购物车删除商品
    public void deleteCart(Integer id){
        items.remove(id);
    }

    //清空购物车
    public void clear(){
        items.clear();
    }

    //更新购物车商品数量
    public void updateCart(Integer id,Integer count){
        //先查看购物车中是否有此商品，若有，修改商品数量，更新总金额
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count);// 修改商品数量
            cartItem.setTotalPrice( cartItem.getPrice() * cartItem.getCount() ); // 更新总金额
        }
    }

    public Cart() {
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        //遍历购物车中的商品总数
        for(Map.Entry<Integer,CartItem>entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }



    public double getTotalPrice() {
        double totalPrice = 0.0;
        //遍历购物车中的商品总数
        for(Map.Entry<Integer,CartItem>entry : items.entrySet()){
//            Integer i = entry.getKey();
            totalPrice += entry.getValue().getTotalPrice();
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
