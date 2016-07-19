package com.lezhian.deleterecyclerview.mvp;

/**
 * Created by hww on 2016/7/19.
 */
public class testBean {

    private String name;
    private int age;
    private String sex;

    public testBean(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
