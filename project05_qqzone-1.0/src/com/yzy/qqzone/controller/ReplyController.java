package com.yzy.qqzone.controller;

import com.yzy.qqzone.pojo.Reply;
import com.yzy.qqzone.pojo.Topic;
import com.yzy.qqzone.pojo.UserBasic;
import com.yzy.qqzone.service.ReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @ClassName ReplyController
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-26 22:50
 * @Version
 **/
public class ReplyController {
    private ReplyService replyService;

    public String addReply(String content,Integer topicId, HttpSession session) {
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        LocalDateTime localDateTime = LocalDateTime.now();
        Reply reply=new Reply(content,localDateTime,author,new Topic(topicId));
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }

    public String delReply(Integer replyId,Integer topicId) {
        replyService.delReply(replyId);
        return "redirect:topic.do?operate=topicDetail&id="+topicId;
    }
}
