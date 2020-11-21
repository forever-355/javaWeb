package com.javaWeb.servlet;

import com.javaWeb.servlet.projo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SeachStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        for (int i = 1; i <= 10; i++) {
            studentArrayList.add(new Student("name"+i, "男", 10+i, 1877000+i));
        }
        req.setAttribute("stuList",studentArrayList);
        req.getRequestDispatcher("/test/test2.jsp").forward(req,resp);

    }
}
