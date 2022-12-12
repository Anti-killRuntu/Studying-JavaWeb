package com.xie.test;

import com.xie.bean.User;
import com.xie.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xie
 * @create 2022-11-05
 */
public class UserDaoTest {
    UserDaoImpl userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("asd") == null){
            System.out.println("用户名已经存在");
        }else{
            System.out.println("用户名可用");

        }

    }

    @Test
    public void saveUser() {
        int user = userDao.saveUser(new User(null, "asd", "123", "asd@163.com"));
        System.out.println(user);
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin 0");
        if (user == null){
            System.out.println("用户不存在或账号密码错误，登录失败");
        }else{
            System.out.println("登录成功");
        }


    }
}