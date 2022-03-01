package com.yzy.bookstore.service.impl;

import com.yzy.bookstore.dao.CartItemDAO;
import com.yzy.bookstore.dao.OrderDAO;
import com.yzy.bookstore.dao.OrderItemDAO;
import com.yzy.bookstore.pojo.CartItem;
import com.yzy.bookstore.pojo.OrderBean;
import com.yzy.bookstore.pojo.OrderItem;
import com.yzy.bookstore.pojo.User;
import com.yzy.bookstore.service.OrderService;

import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 15:24
 * @Version
 **/
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;
    @Override
    public void addOrderBean(OrderBean orderBean) {
        //1) 订单表添加一条记录
        orderDAO.addOrderBean(orderBean);
        //2) 订单详情表添加7条记录
        //orderBean中的orderItemList是空的，此处我们应该根据用户的购物车中的购物车项去转换成一个一个的订单项
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }
        //3) 购物车项表中需要删除对应的7条记录
        for (CartItem cartItem : cartItemMap.values()) {
            cartItemDAO.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderBeanList = orderDAO.getOrderList(user);
        for (OrderBean orderBean: orderBeanList) {
            Integer totalBookCount = orderDAO.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }
        return orderBeanList;
    }
}
