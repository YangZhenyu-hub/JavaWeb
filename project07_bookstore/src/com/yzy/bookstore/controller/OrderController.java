package com.yzy.bookstore.controller;

import com.yzy.bookstore.pojo.OrderBean;
import com.yzy.bookstore.pojo.User;
import com.yzy.bookstore.service.OrderService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-28 14:57
 * @Version
 **/
public class OrderController {
    private OrderService orderService;

    /**
     * 结账
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 15:34 2022/2/28
     * @param session
     * @return java.lang.String
     */
    public String checkout(HttpSession session) {
        OrderBean orderBean = new OrderBean();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
        String format = dateTimeFormatter.format(now);
        orderBean.setOrderNo(UUID.randomUUID().toString()+"_"+format);
        orderBean.setOrderDate(now);

        User user = (User) session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);
        orderService.addOrderBean(orderBean);
        return "index";
    }


    /**
     * 查看订单列表
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 15:27 2022/2/28
     * @param session
     * @return java.lang.String
     */
    public String getOrderList(HttpSession session) {
        User user = (User) session.getAttribute("currUser");
        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);
        session.setAttribute("currUser",user);
        return "order/order";
    }


}
