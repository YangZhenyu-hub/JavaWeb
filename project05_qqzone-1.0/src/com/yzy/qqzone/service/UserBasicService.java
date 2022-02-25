package com.yzy.qqzone.service;

import com.yzy.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassName UserBasicService
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 15:01
 * @Version
 **/
public interface UserBasicService {
    /**
     * 登录业务
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 15:02 2022/2/25
     * @param loginId
     * @param pwd
     * @return com.yzy.qqzone.pojo.UserBasic
     */
    UserBasic login(String loginId, String pwd);

    /**
     * 登录成功后返回好友列表
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 15:07 2022/2/25
     * @param  userBasic
     * @return java.util.List<com.yzy.qqzone.pojo.UserBasic>
     */
    List<UserBasic> getFriendList(UserBasic userBasic);
}
