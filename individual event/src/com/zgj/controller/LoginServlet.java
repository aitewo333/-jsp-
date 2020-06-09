package com.zgj.controller;

import com.zgj.dao.UserDao;
import com.zgj.dao.impl.UserDaoImpl;
import com.zgj.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.shtml")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDaoImpl();
        User user = userDao.login(username,password);

        if (user == null) {
            response.sendRedirect("login.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("login_user",user);

            response.sendRedirect("select.shtml");
        }
    }


}
