package com.interview.chapter2;

import static java.lang.System.*;

class staticTest {
    public static void main(String[] args) {
        out.println("hi");
    }
}

class Cat {
    // 构造方法
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

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
}