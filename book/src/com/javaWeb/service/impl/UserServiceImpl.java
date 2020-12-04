package com.javaWeb.service.impl;

import com.javaWeb.dao.UserDao;
import com.javaWeb.dao.impl.UserDaoImpl;
import com.javaWeb.pojo.User;
import com.javaWeb.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    //注册用户
    public void registUser(User user) {
         UserDao userDao = new UserDaoImpl();
        userDao.saveUser(user);
    }

    @Override
    //登录
    public User Login(User user) {
        UserDao userDao = new UserDaoImpl();
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    //检查用户名是否可用
    public boolean existsUsername(String username) {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryUserByUsername(username) == null){
            //== null表示没在
            return  false;
        }
        return true;
    }

    @Override
    //通过用户id查找用户信息
    public User queryUserById(int newId) {
        return userDao.queryUserById(newId);
    }

    @Override
    //修改用用户信息
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    //删除用户信息
    public void deleteUser(int newId) {
        userDao.deleteUser(newId);
    }
}
