package com.yzy.bookstore.service;

import com.yzy.bookstore.pojo.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 21:54
 * @Version
 **/
public interface UserService {
    /**
     * 根据uname pwd 登录服务
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 22:15 2022/2/27
     * @param uname
     * @param pwd
     * @return com.yzy.bookstore.pojo.User
     */
    User login(String uname, String pwd);

    User getUser(String uname);

    void regist(User user);
}
