package com.javaWeb.dao;

import com.javaWeb.pojo.User;

public interface UserDao {


    /**根据用户名查询用户信息
    * 如果返回null，则表明数据库中没有用户信息
     * */
    public User queryUserByUsername(String username);

    /**
    * 根据用户名和密码查询用户信息
    * */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户，注册的时候
     * 返回-1是插入失败，其他是sql语句反应的行数*/
    public int saveUser(User user);

}
