package com.yzy.bookstore.dao.impl;

import com.yzy.bookstore.dao.UserDAO;
import com.yzy.bookstore.pojo.User;
import com.yzy.myssm.basedao.BaseDAO;

/**
 * @ClassName UserDAOImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-27 21:56
 * @Version
 **/
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User getUser(String uname, String pwd) {
        return super.load("select * from t_user where uname like ? and pwd like ?",uname,pwd);
    }

    @Override
    public User getUser(String uname) {
        return super.load("select * from t_user where uname like ? ",uname);
    }

    @Override
    public void addUser(User user) {
        executeUpdate("insert into t_user values(0,?,?,?,0)",user.getUname(),user.getPwd(),user.getEmail()) ;

    }
}
