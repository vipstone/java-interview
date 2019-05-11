package com.interview.chapter2;

public class Section1  {
    public static void main(String[] args) throws CloneNotSupportedException {
        /********** 克隆 **********/
        CloneTest ct = new CloneTest();
        ct.num = 666;
        System.out.println(ct.num);
        CloneTest ct2 = (CloneTest) ct.clone();
        System.out.println(ct2.num);
        /********** 继承 **********/
        Animal cat = new Cat();
        cat.eat();
    }
}

/**
 * @Description 克隆实现
 **/
class CloneTest implements Cloneable {
    int num;
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest ct = new CloneTest();
        ct.num = 666;
        System.out.println(ct.num);
        CloneTest ct2 = (CloneTest) ct.clone();
        System.out.println(ct2.num);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Animal {
    public void eat() {
        System.out.println("Animal");
    }
}

class Cat extends Animal {

}