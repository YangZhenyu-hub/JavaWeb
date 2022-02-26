package com.yzy.qqzone.dao;

import com.yzy.qqzone.pojo.Reply;
import com.yzy.qqzone.pojo.Topic;

import java.util.List;

/**
 * @ClassName ReplyDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 11:20
 * @Version
 **/
public interface ReplyDAO {
    /**
     * 获取指定日志的回复列表
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:21 2022/2/25
     * @param topic
     * @return java.util.List<com.yzy.qqzone.pojo.Reply>
     */
    List<Reply> getReplyList(Topic topic);

    /**
     * 添加回复
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:22 2022/2/25
     * @param reply
     * @return void
     */
    void addReply(Reply reply);

    /**
     * 删除回复
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 11:23 2022/2/25
     * @param id 回复id
     * @return void
     */
    void delReply(Integer id);

    Reply getReply(Integer id);

}
