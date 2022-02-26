package com.yzy.qqzone.dao;

import com.yzy.qqzone.pojo.HostReply;

/**
 * @ClassName HostReplyDAO
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 11:24
 * @Version
 **/
public interface HostReplyDAO {
    /**
     * 根据replyId获取HostReply
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 21:09 2022/2/26
     * @param replyId
     * @return com.yzy.qqzone.pojo.HostReply
     */
    HostReply getHostReplyByReplyId(Integer replyId);

    void delHostReply(Integer id);

}
