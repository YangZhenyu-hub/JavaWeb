package com.yzy.qqzone.service.impl;

import com.yzy.qqzone.dao.HostReplyDAO;
import com.yzy.qqzone.pojo.HostReply;
import com.yzy.qqzone.service.HostReplyService;

/**
 * @ClassName HostReplyServiceImpl
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-26 21:01
 * @Version
 **/
public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyByReplyId(replyId);
    }

    @Override
    public void delHostReply(Integer id) {
        hostReplyDAO.delHostReply(id);
    }
}
