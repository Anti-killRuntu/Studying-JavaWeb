package com.xie.test;

import com.xie.bean.User;
import com.xie.dao.impl.UserDaoImpl;
import com.xie.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xie
 * @create 2022-11-05
 */
public class UserServiceTest {
    UserServiceImpl service = new UserServiceImpl();

    @Test
    public void registUser() {
        service.registUser(new User(null, "zxc", "123", "zxc@163.com"));
        System.out.println(new UserDaoImpl().queryUserByUsername("zxc"));
    }

    @Test
    public void login() {
        System.out.println(service.login(new User(null, "zxc", "123", "null")));
    }

    @Test
    public void existsUser() {
        System.out.println(service.existsUser("asd"));
    }
}