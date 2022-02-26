package com.yzy.qqzone.dao;

import com.yzy.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassName UserBasicDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 10:58
 * @Version
 **/
public interface UserBasicDAO {
    /**
     * 根据账号密码返回用户实例
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:13 2022/2/25
     * @param loginId 登录Id
     * @param pwd 登录密码
     * @return com.yzy.qqzone.pojo.UserBasic
     */
    public UserBasic getUserBasic(String loginId, String pwd);
    /**
     * 返回指定用户的所有好友列表
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:15 2022/2/25
     * @param userBasic
     * @return java.util.List<com.yzy.qqzone.pojo.UserBasic>
     */
    public List<UserBasic> getUserBasicList(UserBasic userBasic);

    /**
     * 根据指定id查询用户信息
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 15:11 2022/2/25
     * @param id
     * @return userBasic
     */
    public UserBasic getUserBasicById(Integer id);

}
