package com.yzy.qqzone.dao.impl;

import com.yzy.myssm.basedao.BaseDAO;
import com.yzy.qqzone.dao.ReplyDAO;
import com.yzy.qqzone.pojo.Reply;
import com.yzy.qqzone.pojo.Topic;

import java.util.List;

/**
 * @ClassName ReplyDAOImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-26 20:46
 * @Version
 **/
public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyList(Topic topic) {
        return super.executeQuery("select * from t_reply where topic = ?", topic.getId());
    }

    @Override
    public void addReply(Reply reply) {
        executeUpdate("insert into t_reply values(0,?,?,?,?)", reply.getContent(), reply.getReplyDate(), reply.getAuthor().getId(), reply.getTopic().getId());
    }

    @Override
    public void delReply(Integer id) {
        executeUpdate("delete from t_reply where id = ?", id);
    }

    @Override
    public Reply getReply(Integer id) {
        return load("select * from t_reply where id =? " , id);
    }
}
