package com.yzy.bookstore.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Cart
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 10:36
 * @Version
 **/
public class Cart {

    private Map<Integer,CartItem> cartItemMap;  //购物车中购物车项的集合 , 这个Map集合中的key是Book的id
    private Double totalMoney; //购物车的总金额
    private Integer totalCount; //购物车总购物项的总数量
    private Integer totalBookCount; //购物车中书本的数量，而不是购物车项的总数量

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney=0.0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> cartItemEntry : entries) {
                CartItem cartItem = cartItemEntry.getValue();
                totalMoney=totalMoney+cartItem.getBuyCount()*cartItem.getBook().getPrice();
            }
        }
        return totalMoney;
    }

    public Integer getTotalCount() {
        totalCount=0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            totalCount=cartItemMap.size();
        }
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount=0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            for (CartItem cartItem : cartItemMap.values()) {
                totalBookCount += cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }

}
