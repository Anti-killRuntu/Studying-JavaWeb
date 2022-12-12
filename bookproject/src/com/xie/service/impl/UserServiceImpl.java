package com.xie.service.impl;

import com.xie.bean.User;
import com.xie.dao.UserDao;
import com.xie.dao.impl.UserDaoImpl;
import com.xie.service.UserService;

/**
 * @author xie
 * @create 2022-11-05
 */
public class UserServiceImpl implements UserService {
    private UserDao userdao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userdao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userdao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public Boolean existsUser(String username) {
        if(userdao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
