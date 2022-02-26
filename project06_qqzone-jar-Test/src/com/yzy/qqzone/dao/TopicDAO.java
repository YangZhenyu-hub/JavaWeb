package com.yzy.qqzone.dao;

import com.yzy.qqzone.pojo.Topic;
import com.yzy.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassName TopicDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 11:16
 * @Version
 **/
public interface TopicDAO {

    /**
     * 获取指定用户的所有的日志
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:17 2022/2/25
     * @param userBasic 指定用户
     * @return List<Topic>
     */
    public List<Topic> getTopicList(UserBasic userBasic);

    /**
     * 添加日志
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:17 2022/2/25
     * @param topic
     * @return void
     */
    public void addTopic(Topic topic);

    /**
     * 删除日志
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:18 2022/2/25
     * @param topic
     * @return void
     */
    public void deleteTopic(Topic topic);

    /**
     * 获取特定日志信息
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:18 2022/2/25
     * @param id
     * @return com.yzy.qqzone.pojo.Topic
     */
    Topic getTopic(Integer id);
}
