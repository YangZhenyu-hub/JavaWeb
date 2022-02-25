package com.yzy.qqzone.service.impl;

import com.yzy.qqzone.dao.TopicDAO;
import com.yzy.qqzone.pojo.Topic;
import com.yzy.qqzone.pojo.UserBasic;
import com.yzy.qqzone.service.TopicService;

import java.util.List;

/**
 * @ClassName TopicServiceImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 15:30
 * @Version
 **/
public class TopicServiceImpl implements TopicService {
    TopicDAO topicDAO=null;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }
}
