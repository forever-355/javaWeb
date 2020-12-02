package com.javaWeb.utils;

import com.javaWeb.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtil {

    //把map中的值注入到对应的JavaBean属性中
    public  static <T> T copyParmToBean(Map value, T bean){
            try {
                User user = new User();
                System.out.println("注入之前"+bean);
                BeanUtils.populate(bean,value);
                System.out.println("注入之后"+bean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
