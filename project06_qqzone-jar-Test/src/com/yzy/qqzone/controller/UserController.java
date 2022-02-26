package com.yzy.qqzone.controller;

import com.yzy.qqzone.pojo.Topic;
import com.yzy.qqzone.pojo.UserBasic;
import com.yzy.qqzone.service.TopicService;
import com.yzy.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 15:42
 * @Version
 **/
public class UserController {
    private UserBasicService userBasicService;
    private TopicService topicService;
    public String login(String loginId, String pwd , HttpSession session) {
        //1.登录验证
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic != null) {
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);
            //userBasic 保存到是登录者的信息
            session.setAttribute("userBasic",userBasic);
            //friend 保存的当前进入的是谁的空间
            session.setAttribute("friend",userBasic);
            return "index";
        }else {
            return "login";
        }
    }

    public String friend(Integer id,HttpSession session) {
        UserBasic currentFriend = userBasicService.getUserBasicById(id);
        List<Topic> topicList = topicService.getTopicList(currentFriend);
        currentFriend.setTopicList(topicList);
        session.setAttribute("friend",currentFriend);
        return "index";

    }

}
