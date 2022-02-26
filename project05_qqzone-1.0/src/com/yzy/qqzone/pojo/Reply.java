package com.yzy.qqzone.pojo;

import java.time.LocalDateTime;
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
    private String content;
    private LocalDateTime replyDate;
    private UserBasic author; //M:1

    public Reply() {

    }

    public Reply(String content, LocalDateTime replyDate, UserBasic author, Topic topic) {
        this.content = content;
        this.replyDate = replyDate;
        this.author = author;
        this.topic = topic;
    }

    public Reply(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(LocalDateTime replyDate) {
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
