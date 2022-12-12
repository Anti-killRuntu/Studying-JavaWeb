package com.xie.controller;

import com.xie.bean.User;
import com.xie.service.UserService;
import com.xie.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 已废弃不用
 * @author xie
 * @create 2022-11-06
 */
public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = service.login(new User(null,username,password,null));
        if (user == null){
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
