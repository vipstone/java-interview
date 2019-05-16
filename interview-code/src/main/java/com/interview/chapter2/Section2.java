package com.interview.chapter2;


import java.lang.reflect.AnnotatedArrayType;

/*********** 1、成员内部类（可以使用任意修饰符） **********/
class InnerTest {
    public static void main(String[] args) {
        Outter out = new Outter();
        Outter.Inner inner = out.new Inner();
        inner.sayHi();
    }
}

class Outter {
    public Outter() {
        System.out.println("Outter Class.");
    }

    class Inner {
        public void sayHi() {
            System.out.println("Hi, Inner.");
        }
    }
}

/*********** 2、匿名内部类 **********/
class AnonymityTest {
    public static void main(String[] args) {
        AnonymityOutter anonymityOutter = new AnonymityOutter() {
            @Override
            public void hi() {
                System.out.println("Hi, AnonymityOutter.");
            }
        };
        anonymityOutter.hi();
    }
}

interface AnonymityOutter {
    void hi();
}

/*********** 3、静态内部类（可以使用任意修饰符） **********/
class OutterClass {
    public OutterClass() {
        System.out.println("OutterClass Init.");
    }

    protected static class InnerClass {
        public void sayHi() {
            System.out.println("Hi, InnerClass.");
        }
    }
}

class InnerClassTest {
    public static void main(String[] args) {
        OutterClass.InnerClass innerClass = new OutterClass.InnerClass();
        innerClass.sayHi();
    }
}
