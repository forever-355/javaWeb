package com.javaWeb.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javaWeb.proj.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    //1.javaBean和json字符串的互转
    @Test
    public void test1(){
        Person person = new Person(1,"张三");

        // 创建Gson对象实例
        Gson gson = new Gson();
        // toJson方法可以把java对象转换成为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);

        // fromJson把json字符串转换回Java对象
        // 第一个参数是json字符串
        // 第二个参数是转换回去的Java对象类型
        Person person1 = gson.fromJson(personJsonString,Person.class);
        System.out.println(person1);
    }

    //2.list集合和json字符串的互转
    @Test
    public void test2(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"小松鼠"));
        list.add(new Person(2,"三岛"));

        //创建Gson实例化对象
        Gson gson = new Gson();
        //把list转换为json字符串
        String personListJsonString = gson.toJson(list);

        //把json字符串转换为list集合
        List<Person> newList = gson.fromJson(personListJsonString,new PersonListType().getType());
        System.out.println(newList);
        System.out.println(newList.get(0));
        System.out.println(newList.get(1));
    }

    //3.map集合和json字符串的互转
    @Test
    public void Test3(){
        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(1,new Person(1,"小松鼠"));
        personMap.put(2,new Person(2,"三岛影像"));

        //创建Gson实例化对象
        Gson gson = new Gson();

        //把map集合转化为json字符串
        String mapStringJson = gson.toJson(personMap);
        System.out.println(mapStringJson);

        //把json字符串转换为map集合
        Map<Integer,Person> personMap1 = gson.fromJson(mapStringJson,new TypeToken<HashMap<Integer,Person>>(){}.getType());
        System.out.println(personMap1);
        System.out.println(personMap1.get(1));
        System.out.println(personMap1.get(2));
    }
}
