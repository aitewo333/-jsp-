package com.zgj.dao.impl;

import com.zgj.dao.MessageDao;
import com.zgj.entity.Message;
import com.zgj.utils.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl extends BaseDao implements MessageDao {
    @Override
    public List<Message> getList(int userId) {
        String sql = "select * from message where recieve_user_id = ?";
        ResultSet rs = super.executeQuery(sql,userId);
        List<Message> list = new ArrayList<Message>();
        try {
            while(rs.next()){
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setSendUserId(rs.getInt("send_user_id"));
                message.setRecieveUserId(rs.getInt("recieve_user_id"));
                message.setTitle(rs.getString("title"));
                message.setContent(rs.getString("content"));
                message.setState(rs.getInt("state"));
                message.setSendDate(rs.getTimestamp("sendDate"));

                list.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            super.close(rs);
        }
        return list;
    }

    @Override
    public int add(Message message) {
        String sql = "insert into message(send_user_id,recieve_user_id,title,content,state) values(?,?,?,?,0)";
        return super.executeUpdate(sql,message.getSendUserId(),message.getRecieveUserId(),message.getTitle(),message.getContent());
    }

    @Override
    public int delete(int id) {
        String sql = "delete from message where id = ?";
        return super.executeUpdate(sql,id);
    }
}
