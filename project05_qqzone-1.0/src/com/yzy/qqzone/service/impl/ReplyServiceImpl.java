package com.yzy.qqzone.service.impl;

import com.yzy.qqzone.dao.ReplyDAO;
import com.yzy.qqzone.pojo.HostReply;
import com.yzy.qqzone.pojo.Reply;
import com.yzy.qqzone.pojo.Topic;
import com.yzy.qqzone.pojo.UserBasic;
import com.yzy.qqzone.service.HostReplyService;
import com.yzy.qqzone.service.ReplyService;
import com.yzy.qqzone.service.UserBasicService;

import java.util.List;

/**
 * @ClassName ReplyServiceImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-26 20:43
 * @Version
 **/
public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
         List<Reply> replyList= replyDAO.getReplyList(new Topic(topicId));
        for (int i = 0; i < replyList.size(); i++) {
            Reply reply = replyList.get(i);
            //1.将关联的作者设置进去
            UserBasic author = userBasicService.getUserBasicById(reply.getAuthor().getId());
            reply.setAuthor(author);


            //2.将关联的HostReply设置进去
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Integer replyId) {
        //1.根据id获取到reply
        Reply reply = replyDAO.getReply(replyId);
        if(reply!=null){
            //2.如果reply有关联的hostReply，则先删除hostReply
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            if(hostReply!=null){
                hostReplyService.delHostReply(hostReply.getId());
            }
            //3.删除reply
            replyDAO.delReply(replyId);
        }
    }

    @Override
    public void delReplyList(Topic topic) {

    }
}
