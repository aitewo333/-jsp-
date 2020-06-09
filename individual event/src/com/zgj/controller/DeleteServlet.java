package com.zgj.controller;

import com.zgj.dao.MessageDao;
import com.zgj.dao.impl.MessageDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delete.shtml")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        MessageDao messageDao = new MessageDaoImpl();
        messageDao.delete(Integer.parseInt(id));

        response.sendRedirect("select.shtml");
    }
}
