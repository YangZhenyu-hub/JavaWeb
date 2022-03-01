package com.yzy.bookstore.dao.impl;

import com.yzy.bookstore.dao.OrderDAO;
import com.yzy.bookstore.pojo.OrderBean;
import com.yzy.bookstore.pojo.User;
import com.yzy.myssm.basedao.BaseDAO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName OrderDAOImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 15:46
 * @Version
 **/
public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        //返回订单id
        int orderBeanId = super.executeUpdate("insert into t_order values(0,?,?,?,?,?)", orderBean.getOrderNo(), orderBean.getOrderDate(), orderBean.getOrderUser().getId(), orderBean.getOrderMoney(), orderBean.getOrderStatus());
        //因为此处的orderBean.Id为null  id为数据库自增  故需要赋予值
        orderBean.setId(orderBeanId);
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        return executeQuery("SELECT * FROM t_order WHERE orderUser = ?",user.getId());
    }

    @Override
    public Integer getOrderTotalBookCount(OrderBean orderBean) {
        String sql="SELECT SUM(t3.buyCount) AS totalBookCount,t3.orderBean FROM" +
                "(" +
                "SELECT t1.`id`,t2.`buyCount`,t2.`orderBean`" +
                "FROM t_order t1 INNER JOIN t_order_item t2 " +
                "ON t1.`id`= t2.`orderBean` " +
                "WHERE t1.`orderUser`=?" +
                ")t3 WHERE t3.orderBean= ? GROUP BY t3.orderBean";
        return ((BigDecimal)executeComplexQuery(sql,orderBean.getOrderUser().getId(),orderBean.getId())[0]).intValue();
    }
}
