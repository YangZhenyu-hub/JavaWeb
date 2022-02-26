package com.yzy.qqzone.service.impl;

import com.yzy.qqzone.dao.TopicDAO;
import com.yzy.qqzone.pojo.Reply;
import com.yzy.qqzone.pojo.Topic;
import com.yzy.qqzone.pojo.UserBasic;
import com.yzy.qqzone.service.ReplyService;
import com.yzy.qqzone.service.TopicService;
import com.yzy.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @ClassName TopicServiceImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 15:30
 * @Version
 **/
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO=null;
    private ReplyService replyService;
    private UserBasicService userBasicService;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    @Override
    public Topic getTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        UserBasic author = topic.getAuthor();
        author = userBasicService.getUserBasicById(author.getId());
        topic.setAuthor(author);
        return topic;
    }

    @Override
    public void delTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        if(topic!=null){
            replyService.delReplyList(topic);
            topicDAO.deleteTopic(topic);
        }
    }

    @Override
    public Topic getTopicDetailById(Integer id) {

        Topic topic = getTopic(id);
        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
        topic.setReplyList(replyList);
        return topic;
    }
}
