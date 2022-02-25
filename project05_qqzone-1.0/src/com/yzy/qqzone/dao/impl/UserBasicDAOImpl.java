package com.yzy.qqzone.dao.impl;

import com.yzy.myssm.basedao.BaseDAO;
import com.yzy.qqzone.dao.UserBasicDAO;
import com.yzy.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassName UserBasicDAOImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 11:25
 * @Version
 **/
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("select * from t_user_basic where loginId=? and pwd=?", loginId, pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        String sql="select fid as id from t_friend where uid=?";
        return super.executeQuery(sql,userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return super.load("select * from t_user_basic where id=?", id);
    }
}
