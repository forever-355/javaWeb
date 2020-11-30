package com.javaWeb.test;

import com.javaWeb.utils.JdbcUtils;
import org.junit.Test;
import java.sql.Connection;

/*
* 测试类，看是否能连接到数据库连接池*/
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}
