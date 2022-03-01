package com.yzy.bookstore.dao;

import com.yzy.bookstore.pojo.User;

/**
 * @ClassName UserDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 21:55
 * @Version
 **/
public interface UserDAO {
    /**
     * 根据uname ,pwd 获取User对象
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 22:01 2022/2/27
     * @param uname
     * @param pwd
     * @return com.yzy.bookstore.pojo.User
     */
    User getUser(String uname, String pwd);

    /**
     * 根据用户名获取用户
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:04 2022/3/1
     * @param uname
     * @return com.yzy.bookstore.pojo.User
     */
    User getUser(String uname);

    /**
     * 注册添加用户
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:14 2022/3/1
     * @param user
     * @return void
     */
    void addUser(User user);
}
