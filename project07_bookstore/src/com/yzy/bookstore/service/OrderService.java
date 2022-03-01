package com.yzy.bookstore.service;

import com.yzy.bookstore.pojo.OrderBean;
import com.yzy.bookstore.pojo.User;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 15:24
 * @Version
 **/
public interface OrderService {
    /**
     * 增加一条订单记录
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 15:25 2022/2/28
     * @param orderBean
     * @return void
     */
    void addOrderBean(OrderBean orderBean);

    /**
     * 获取订单记录
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 15:26 2022/2/28
     * @param user
     * @return java.util.List<com.yzy.bookstore.pojo.OrderBean>
     */
    List<OrderBean> getOrderList(User user);
}
