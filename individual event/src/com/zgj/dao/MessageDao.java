package com.zgj.dao;

import com.zgj.entity.Message;

import java.util.List;

public interface MessageDao {
    //根据接收人编号查询短消息
    public List<Message> getList(int userId);

    //    添加短消息
    public int add(Message message);

//    根据短消息编号删除对应的短消息
    public int delete(int id);
}
