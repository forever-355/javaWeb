package com.javaWeb.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;


public class I18n {
    @Test
    public void testlocale(){
        //获取系统默认的语言，国家信息
        Locale locale = Locale.getDefault();
        System.out.println(locale);

//        Locale[] availableLocales = Locale.getAvailableLocales();
//        int i = 0;
//        while(availableLocales != null){
//            System.out.println(availableLocales[i]);
//            i ++;
//        }

    }
    @Test
    //管理配置文件类 i18n_zh_CN.properties
    public void testI18n(){
        // 得到我们需要的Locale对象
        Locale locale = Locale.CHINA;
        System.out.println(locale);
        // 通过指定的basename和Locale对象，读取 相应的配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
        System.out.println("username：" + bundle.getString("username"));
        System.out.println("password：" + bundle.getString("password"));
        System.out.println("sex：" + bundle.getString("sex"));
        System.out.println("age：" + bundle.getString("age"));
    }
}
