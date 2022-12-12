package com.xie.dao.impl;

import com.xie.bean.User;
import com.xie.dao.UserDao;

/**
 * @author xie
 * @create 2022-11-05
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }


    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return queryForOne(sql,User.class,username,password);
    }

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return queryForOne(sql,User.class,username);
    }

}

