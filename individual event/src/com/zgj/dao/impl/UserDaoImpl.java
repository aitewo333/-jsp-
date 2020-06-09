package com.zgj.dao.impl;

import com.zgj.dao.UserDao;
import com.zgj.entity.User;
import com.zgj.utils.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int add(User user) {
        String sql = "insert into user(username,password,nickname) values(?,?,?)";
        return super.executeUpdate(sql,user.getUsername(),user.getPassword(),user.getNickname());
    }

    @Override
    public User login(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        ResultSet rs = super.executeQuery(sql,username,password);

        User user = null;
        try {
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setNickname(rs.getString("nickName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            super.close(rs);
        }
        return user;
    }
}
