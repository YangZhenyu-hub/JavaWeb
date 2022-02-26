package com.yzy.qqzone.dao.impl;

import com.yzy.myssm.basedao.BaseDAO;
import com.yzy.qqzone.dao.HostReplyDAO;
import com.yzy.qqzone.pojo.HostReply;

/**
 * @ClassName HostReplyDAOImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-26 21:02
 * @Version
 **/
public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer reply) {
        return super.load("select * from t_host_reply where reply =?",reply);
    }

    @Override
    public void delHostReply(Integer id) {
        super.executeUpdate("delete from t_host_reply where id=?", id);
    }
}
