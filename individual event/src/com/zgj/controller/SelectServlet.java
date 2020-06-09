package com.zgj.controller;

import com.zgj.dao.MessageDao;
import com.zgj.dao.impl.MessageDaoImpl;
import com.zgj.entity.Message;
import com.zgj.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectServlet",urlPatterns = "/select.shtml")
public class SelectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取登录用户信息
        User user = (User)request.getSession().getAttribute("login_user");

        MessageDao messageDao = new MessageDaoImpl();
        //获取登录用户编号
        List<Message> list = messageDao.getList(user.getId());

        request.setAttribute("msgList",list);
        request.getRequestDispatcher("/messages.jsp").forward(request,response);

    }
}
