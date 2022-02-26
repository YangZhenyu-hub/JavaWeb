package com.yzy.qqzone.dao.impl;

import com.yzy.myssm.basedao.BaseDAO;
import com.yzy.qqzone.dao.TopicDAO;
import com.yzy.qqzone.pojo.Topic;
import com.yzy.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @ClassName TopicDAOImp
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-25 11:26
 * @Version
 **/
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO{
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return super.executeQuery("select * from t_topic where author=?", userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void deleteTopic(Topic topic) {
        executeUpdate("delete from t_topic where id = ? " , topic.getId());
    }

    @Override
    public Topic getTopic(Integer id) {
        return super.load("select * from t_topic where id=?",id);
    }
}
