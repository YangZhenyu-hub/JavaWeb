package com.yzy.qqzone.service;

import com.yzy.qqzone.pojo.Reply;
import com.yzy.qqzone.pojo.Topic;

import java.util.List;

/**
 * @ClassName ReplyService
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 15:25
 * @Version
 **/
public interface ReplyService {
    /**
     * 根据指定topicId查询关联的回复信息
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 20:44 2022/2/26
     * @param topicId
     * @return java.util.List<com.yzy.qqzone.pojo.Reply>
     */
    List<Reply> getReplyListByTopicId(Integer topicId);

    void addReply(Reply reply);

    void delReply(Integer replyId);

    void delReplyList(Topic topic);
}
