package com.xie.controller;

import com.xie.bean.User;
import com.xie.service.UserService;
import com.xie.service.impl.UserServiceImpl;
import com.xie.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author xie
 * @create 2022-11-08
 */
public class UserServlet extends BaseServlet {
    private UserService service = new UserServiceImpl();

    /**
     * 处理注销功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }
    /**
     * 处理登录的功能
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = service.login(new User(null,username,password,null));
        if (user == null){
            // 把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户或密码错误！");
            req.setAttribute("username", username);
            //   跳回登录页面
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
        }else{
            //登陆成功
            //保存用户信息到session域中
            req.getSession().setAttribute("user",user);
            //跳转登陆成功界面
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }
    }
    /**
     *
     * 处理注册的功能
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());


        if (token!=null && token.equalsIgnoreCase(code)) {

            if (service.existsUser(user.getUsername())) {
                System.out.println("用户名[" + user.getUsername() + "]已经存在");
                // 把回显信息，保存到Request域中
                req.setAttribute("msg", "用户名已存在！！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //注册成功把用户信息保存到数据库
                service.registUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        }else {

            // 把回显信息，保存到Request域中
            req.setAttribute("msg", "验证码错误！！");

            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


}