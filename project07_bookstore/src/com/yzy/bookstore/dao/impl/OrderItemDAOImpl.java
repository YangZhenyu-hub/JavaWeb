package com.yzy.bookstore.dao.impl;

import com.yzy.bookstore.dao.OrderItemDAO;
import com.yzy.bookstore.pojo.OrderItem;
import com.yzy.myssm.basedao.BaseDAO;

/**
 * @ClassName OrderItemDAOImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 15:59
 * @Version
 **/
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        super.executeUpdate("insert into t_order_item values(0,?,?,?)", orderItem.getBook().getId(), orderItem.getBuyCount(), orderItem.getOrderBean().getId());
    }
}
