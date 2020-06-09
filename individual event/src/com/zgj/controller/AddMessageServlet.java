package com.zgj.controller;

import com.zgj.dao.MessageDao;
import com.zgj.dao.impl.MessageDaoImpl;
import com.zgj.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddMessageServlet",urlPatterns = "/add.shtml")
public class AddMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String sendId = request.getParameter("send_id");
        String recId = request.getParameter("recive_id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Message message = new Message();
        message.setSendUserId(Integer.parseInt(sendId));
        message.setRecieveUserId(Integer.parseInt(recId));
        message.setTitle(title);
        message.setContent(content);

        MessageDao messageDao = new MessageDaoImpl();
        messageDao.add(message);

        // 添加成功后跳转到收件箱页面
        response.sendRedirect("select.shtml");

    }

}
