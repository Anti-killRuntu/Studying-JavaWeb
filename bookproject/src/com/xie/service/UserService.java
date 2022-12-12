package com.xie.service;

import com.xie.bean.User;

/**
 * @author xie
 * @create 2022-11-05
 */
public interface UserService {
    /**
     * 注册用户
     */
    public void registUser(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 判断用户是否存在
     * @param username
     * @return
     */
    public Boolean existsUser(String username);
}
