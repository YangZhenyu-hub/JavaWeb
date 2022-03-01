package com.yzy.bookstore.service.impl;

import com.yzy.bookstore.dao.UserDAO;
import com.yzy.bookstore.pojo.User;
import com.yzy.bookstore.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 21:57
 * @Version
 **/
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname,pwd);
    }

    @Override
    public User getUser(String uname) {
        return userDAO.getUser(uname);
    }

    @Override
    public void regist(User user) {
        userDAO.addUser(user);
    }
}
