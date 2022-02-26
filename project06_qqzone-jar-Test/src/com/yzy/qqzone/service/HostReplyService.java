package com.yzy.qqzone.service;

import com.yzy.qqzone.pojo.HostReply;

/**
 * @ClassName HostReplyService
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-26 20:56
 * @Version
 **/
public interface HostReplyService {
    /**
     * 根据replyId获得HostReply
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 21:00 2022/2/26
     * @param replyId
     * @return HostReply
     */
    HostReply getHostReplyByReplyId(Integer replyId);


    void delHostReply(Integer id);
}
