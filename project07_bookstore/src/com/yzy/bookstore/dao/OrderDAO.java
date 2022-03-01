package com.yzy.bookstore.dao;

import com.yzy.bookstore.pojo.OrderBean;
import com.yzy.bookstore.pojo.User;

import java.util.List;

/**
 * @ClassName OrderDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 15:45
 * @Version
 **/
public interface OrderDAO {
    /**
     * 添加订单
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 15:48 2022/2/28
     * @param orderBean
     * @return void
     */
    void addOrderBean(OrderBean orderBean);

    /**
     * 获取订单列表
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 19:14 2022/2/28
     * @param user
     * @return java.util.List<com.yzy.bookstore.pojo.OrderBean>
     */
    List<OrderBean> getOrderList(User user);

    /**
     * 获取当前订单包含的书本数量
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 19:14 2022/2/28
     * @param orderBean
     * @return java.lang.Integer
     */
    Integer getOrderTotalBookCount(OrderBean orderBean);

}
