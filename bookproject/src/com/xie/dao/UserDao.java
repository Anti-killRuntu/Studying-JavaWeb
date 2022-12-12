package com.xie.dao;

import com.xie.bean.User;

/**
 * @author xie
 * @create 2022-11-05
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(User user);
    public User queryUserByUsernameAndPassword(String username, String password);

}
