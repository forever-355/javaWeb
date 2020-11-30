package com.javaWeb.test;

import com.javaWeb.pojo.User;
import com.javaWeb.service.UserService;
import com.javaWeb.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    //注册用户
    public void registUser() {
        userService.registUser(new User(null,"王五","123456","345678@qq.com"));
        userService.registUser(new User(null,"赵六","123456","456789@qq.com"));
    }

    @Test
    //登录
    //返回null登录失败，返回整条登录数据登录成功
    public void Login() {
        System.out.println(userService.Login(new User(null,"张三","123456",null)));
    }

    @Test
    //检查用户名是否可用
    public void existsUsername() {
        if(userService.existsUsername("张三")){
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用！");
        }
    }
}