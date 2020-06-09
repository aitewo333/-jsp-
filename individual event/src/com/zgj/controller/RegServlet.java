package com.zgj.controller;

import com.zgj.dao.UserDao;
import com.zgj.dao.impl.UserDaoImpl;
import com.zgj.entity.User;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "RegServlet",urlPatterns = "/reg.shtml")
public class RegServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");

        User user = new User(username,password,nickname);

        UserDao userDao = new UserDaoImpl();
        userDao.add(user);

        response.sendRedirect("login.jsp");
    }


}
