package com.javaWeb.web;

import com.javaWeb.pojo.User;
import com.javaWeb.service.UserService;
import com.javaWeb.service.impl.UserServiceImpl;
import com.javaWeb.utils.WebUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    //1.处理登录的方法
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数(用户名和密码)
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.调用userService.login()登录处理业务
        User loginUser = userService.Login(new User(null, username, password, null));
        if (loginUser == null) {  //如果等于null,说明登录失败
            //提示用户名或密码错误
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            System.out.println("用户名或密码错误！");
        } else {
            //登录成功
            //保存用户的登录信息到session域中
            req.getSession().setAttribute("user",loginUser);
            //跳到成功页面login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    //2.处理注册的方法
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtil.copyParmToBean(req.getParameterMap(), new User());

        //2、检查验证码是否正确,这里写死,验证码为:abcde
        if ("abcde".equalsIgnoreCase(code)) {
           //3、检查用户名是否可用
            if (userService.existsUsername(username)) {
               System.out.println("用户名[" + username + "]已存在!");

                //把回显数据保存在数据域当中
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                //用户名存在就跳回注册页面
                   req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //用户名在数据库中不存在，可用
                //调用Sservice保存到数据库
                userService.registUser(new User(null, username, password, email));
                //跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else { //验证码错误

            //把回显数据保存在数据域当中
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            System.out.println("验证码[" + code + "]错误");
            //验证码错误跳回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }

        }


    //注销用户
    protected void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.销毁session中用户登录的信息
        req.getSession().invalidate();
        //2.重定向到首页(或登录页面)
        resp.sendRedirect(req.getContextPath());
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
////        if("login".equals(action)){
////            login(req,resp);
////
////        } else if("regist".equals(action)){
////            regist(req,resp);
////        }
//        try { //利用反射方式，避免写大量的else if
//            //获取action业务鉴别字符串，获取相应的业务，方法反射对象
//            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
//
//            //调用目标业务，方法
//            method.invoke(this,req,resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



    //保存修改的用户
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数，封装称为user对象
        User newUser = new User();
        User oldUser = (User) req.getSession().getAttribute("user");
        newUser.setId(oldUser.getId());
        newUser.setEmail(req.getParameter("email"));
        newUser.setPassword(req.getParameter("password"));
        newUser.setUsername(req.getParameter("username"));
        //2.调用userService.updateUser(user),修改用户
        userService.updateUser(newUser);
        //3.地址重定向
        //  ????
        req.getSession().setAttribute("user",newUser);
        req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
    }

    //注销用户，从数据库中删除
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取用户id，用户编号
        String id = req.getParameter("id");
        //把id的string类型转换成Interger类型
        int newId = Integer.parseInt(id);
        //2.调用userService.delete方法删除用户
        userService.deleteUser(newId);
        //3.销毁session中用户登录的信息
        req.getSession().invalidate();
        //4.跳到图示列表页面：/bookServlet?action=select
        resp.sendRedirect(req.getContextPath());


    }
}
