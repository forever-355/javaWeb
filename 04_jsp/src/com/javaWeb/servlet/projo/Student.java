package com.javaWeb.servlet.projo;

public class Student {
    private String name;
    private String sex;
    private Integer age;
    private Integer sno;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getTel() {
        return sno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setTel(Integer tel) {
        this.sno = tel;
    }

    public Student() {
    }

    public Student(String name, String sex, Integer age, Integer tel) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sno = tel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tel=" + sno +
                '}';
    }
}
