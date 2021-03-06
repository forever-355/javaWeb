package com.javaWeb.dao.impl;

import com.javaWeb.dao.UserDao;
import com.javaWeb.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from table_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    //用户登录时，验证用户名和密码
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from table_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    //注册用户的时候，向数据库中插入一条数据
    public int saveUser(User user) {
        String sql = "insert into table_user(username,password,email) values (?,?,?);";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    //通过用户编号查找用户
    public User queryUserById(int id) {
        String sql = "select * from table_user where id = ?";
        return queryForOne(User.class,sql,id);
    }

    @Override
    //修改用户
    public int updateUser(User user) {
        String sql = "update table_user set username=?,password=?,email=? where id = ?";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getId());
    }

    @Override
    //通过用户id删除用户
    public int deleteUser(int newId) {
        String sql = "delete from table_user where id = ?";
        return update(sql,newId);
    }


}
