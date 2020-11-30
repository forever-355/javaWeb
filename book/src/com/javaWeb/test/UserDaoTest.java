package com.javaWeb.test;

import com.javaWeb.dao.UserDao;
import com.javaWeb.dao.impl.UserDaoImpl;
import com.javaWeb.pojo.User;
import org.junit.Test;

/*
* 测试类，测试注册时输入的用户名是否可用（用户名是否存在）*/
public class UserDaoTest {
    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        User name = userDao.queryUserByUsername("张三");
        if(name == null){ //数据库中没有查询的用户名
            System.out.println("用户名可用！");
        } else{
            System.out.println("用户名已存在！");
        }

    }
    //用户登录时，验证用户名和密码
    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryUserByUsernameAndPassword("张三", "123456");
        if(user == null){ //数据库中未查询到数据
            System.out.println("用户名或密码错误，请重新输入！");
        } else {
            System.out.println("登录成功！");
        }
    }

    @Test
    //注册一个用户时，向数据库中插入一条数据
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        //打印的数字代表影响的行数
        //打印-1代表操作失败
        System.out.println(userDao.saveUser(new User(null,"李四","123456","234567@qq.com")));
    }
}