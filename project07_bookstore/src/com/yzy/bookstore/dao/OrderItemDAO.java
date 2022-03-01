package com.yzy.bookstore.dao;

import com.yzy.bookstore.pojo.OrderItem;

/**
 * @ClassName OrderItemDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 15:56
 * @Version
 **/
public interface OrderItemDAO {
    /**
     * 添加订单项
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 15:57 2022/2/28
     * @param orderItem
     * @return void
     */
    void addOrderItem(OrderItem orderItem);
}
