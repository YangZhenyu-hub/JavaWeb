package com.yzy.qqzone.pojo;

import java.util.Date;

/**
 * @ClassName reply
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 10:36
 * @Version
 **/
public class Reply {
    private Integer id;
    private String context;
    private Date replyDate;
    private UserBasic author; //M:1

    public Reply() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public HostReply getHostReply() {
        return hostReply;
    }

    public void setHostReply(HostReply hostReply) {
        this.hostReply = hostReply;
    }

    private Topic topic; //M：1

    private HostReply hostReply; //1:1
}
