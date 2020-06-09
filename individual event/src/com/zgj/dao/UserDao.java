package com.zgj.dao;

import com.zgj.entity.User;

public interface UserDao {
//    添加用户/注册用户
    public int add(User user);

//    用户登录
    public User login(String username,String password);


}
