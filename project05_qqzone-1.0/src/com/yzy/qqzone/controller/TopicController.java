package com.yzy.qqzone.controller;

import com.yzy.qqzone.pojo.Reply;
import com.yzy.qqzone.pojo.Topic;
import com.yzy.qqzone.service.ReplyService;
import com.yzy.qqzone.service.TopicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName TopicController
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-26 17:18
 * @Version
 **/
public class TopicController {
    private TopicService topicService;
    public String topicDetail(Integer id, HttpSession session) {
        Topic topic = topicService.getTopicDetailById(id);
        session.setAttribute("topic",topic);
        return "frames/detail";
    }
}
