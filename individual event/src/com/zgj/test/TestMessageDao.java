package com.zgj.test;

import com.zgj.dao.MessageDao;
import com.zgj.dao.impl.MessageDaoImpl;
import com.zgj.entity.Message;

import java.util.List;

public class TestMessageDao {
    public static void main(String[] args) {
        MessageDao messageDao = new MessageDaoImpl();
        List<Message> list = messageDao.getList(3);

        for (Message message : list) {
            System.out.println(message.getTitle());
        }
    }
}
