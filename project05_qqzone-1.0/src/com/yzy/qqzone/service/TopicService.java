package com.yzy.qqzone.service;

import com.yzy.qqzone.pojo.Topic;
import com.yzy.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassName TopicService
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 15:24
 * @Version
 **/
public interface TopicService {
    /**
     * 查询用户的日志列表
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 15:28 2022/2/25
     * @param userBasic
     * @return List<Topic>
     */
    List<Topic> getTopicList(UserBasic userBasic);
}
