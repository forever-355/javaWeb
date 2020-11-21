<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 清风慕竹
  Date: 2020-11-13
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         errorPage="/errorPage.jsp"
         language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--声明脚本--%>
<%--1.声明属性--%>
    <%!
        private Integer age;
        private String name;
        private static Map<String,Object> map;
    %>

<%--2.声明静态代码块--%>
    <%!
        static{
            map = new HashMap<String,Object>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
        }
    %>

<%--3.声明类方法--%>
    <%!
        public void ppp(){
            System.out.println("hello,world!");
        }
    %>

<%--4.声明内部类--%>
    <%!
        public static class A{
            private Integer age = 12;
            private String abc = "abc";
        }
    %>


<%--表达式脚本--%>
<%--1.输出整型--%>
<%--2.输出浮点型--%>
<%--3.输出字符串--%>
<%--4.输出对象--%>
    <%=12%>     </br>
    <%=12.12%>  </br>
    <%="我是字符串"%>    </br>
    <%=map%>    </br>

<%--代码脚本--%>
<%--1.代码脚本  if语句--%>
    <%
        int i = -1;
        if(i>0){
            System.out.println("i大于0");
        } else{
            System.out.println("i不大于0");
        }
    %>
<%--2.代码脚本  for 循环语句--%>
    <%
        for(int n=0;n<5;n++){
            System.out.println("第"+(n+1)+"次循环");
        }
    %>
</body>
</html>
