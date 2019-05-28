package com.interview.chapter2;

public class Section1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        /********** 克隆 **********/
        CloneInstance ct = new CloneInstance();
        ct.num = 666;
        System.out.println(ct.num);
        CloneInstance ct2 = (CloneInstance) ct.clone();
        System.out.println(ct2.num);
        /********** 继承 **********/
        Animal cat = new Cat();
        cat.eat();
    }
}

/**
 * @Description 克隆实现
 **/
class CloneInstance implements Cloneable {
    int num;

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneInstance ct = new CloneInstance();
        ct.num = 666;
        System.out.println(ct.num);
        CloneInstance ct2 = (CloneInstance) ct.clone();
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

/********** 继承执行顺序面试题 **********/
class ExecTest {
    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Parent {
    {
        System.out.print("1");
    }

    static {
        System.out.print("2");
    }

    public Parent() {
        System.out.print("3");
    }
}

class Son extends Parent {
    {
        System.out.print("4");
    }

    static {
        System.out.print("5");
    }

    public Son() {
        System.out.print("6");
    }
}

/********* 继承面试题 **********/
class A {
    //    public int x = 0;
//    public static int y = 0;
    public void m(A a) {
        System.out.println("AA");
    }

    public void m(D d) {
        System.out.println("AD");
    }

//    public void m(B b) {
//        System.out.println("AB");
//    }
}

class B extends A {
    //    public int x = 1;
//    public static int y = 2;
    @Override
    public void m(A a) {
        System.out.println("BA");
    }

    public void m(B b) {
        System.out.println("BB");
    }

    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        a.m(a);
        a.m(b);
        a.m(c);
        a.m(d);
//        System.out.print(a.x);
//        System.out.print(a.y);
    }
}

class C extends B {
}

class D extends B {
}
