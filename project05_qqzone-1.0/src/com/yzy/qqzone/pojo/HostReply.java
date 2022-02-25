package com.yzy.qqzone.pojo;

import java.util.Date;

/**
 * @ClassName HostReply
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 10:37
 * @Version
 **/
public class HostReply {

    private Integer id;
    private String context;
    private Date hostReplayDate;
    private UserBasic author; //M:1
    private Reply reply; //1:1


    public HostReply() {

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

    public Date getHostReplayDate() {
        return hostReplayDate;
    }

    public void setHostReplayDate(Date hostReplayDate) {
        this.hostReplayDate = hostReplayDate;
    }

    public UserBasic getAuthor() {
        return author;
    }

    public void setAuthor(UserBasic author) {
        this.author = author;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }
}
