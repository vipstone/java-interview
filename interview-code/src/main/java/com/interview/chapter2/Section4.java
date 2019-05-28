package com.interview.chapter2;

class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 等号赋值（ 基本类型）
        int number = 6;
        int number2 = number;
        // 修改 number2 的值
        number2 = 9;
        System.out.println("number：" + number);
        System.out.println("number2：" + number2);
        Dog dog = new Dog();
        dog.name = "旺财";
        dog.age = 5;
        Dog dog2 = dog;
        // 修改 dog2 的值
        dog2.name = "大黄";
        dog2.age = 3;
        System.out.println(dog.name + "，" + dog.age + "岁");
        System.out.println(dog2.name + "，" + dog2.age + "岁");
        // -------------------------- 克隆 ----------------------------
        Dog dog3 = (Dog) dog.clone();
        dog3.name = "小白";
        dog3.age = 2;
        System.out.println(dog.name + "，" + dog.age + "岁");
        System.out.println(dog3.name + "，" + dog3.age + "岁");
        // -------------------------- 浅克隆 ----------------------------
        DogChild dogChild = new DogChild();
        dogChild.name = "二狗";
        Dog dog4 = new Dog();
        dog4.name = "大黄";
        dog4.dogChild = dogChild;
        Dog dog5 = (Dog) dog4.clone();
        dog5.name = "旺财";
        dog5.dogChild.name = "狗二";
        System.out.println("dog name 4："+dog4.name);
        System.out.println("dog name 5："+dog5.name);
        System.out.println("dog child name 4："+dog4.dogChild.name);
        System.out.println("dog child name 5："+dog5.dogChild.name);
    }
}


class Dog implements Cloneable {
    public String name;
    public int age;
    public DogChild dogChild;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class DogChild {
    public String name;
    public int age;
}