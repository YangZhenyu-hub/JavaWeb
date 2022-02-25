package com.yzy.qqzone.service.impl;

import com.yzy.qqzone.dao.UserBasicDAO;
import com.yzy.qqzone.pojo.UserBasic;
import com.yzy.qqzone.service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserBasicServiceImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 15:03
 * @Version
 **/
public class UserBasicServiceImpl implements UserBasicService {
    private UserBasicDAO userBasicDAO=null;
    @Override
    public UserBasic login(String loginId, String pwd) {

        UserBasic userBasic = userBasicDAO.getUserBasic(loginId, pwd);

        return userBasic;
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic ) {
        List<UserBasic> userBasicList = userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList=new ArrayList<>(userBasicList.size());
        for (int i = 0; i < userBasicList.size(); i++) {
            UserBasic friend = userBasicList.get(i);
            friend = userBasicDAO.getUserBasicById(friend.getId());
            friendList.add(friend);
        }
        return friendList;
    }
}
