package com.interview.chapter4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class myClass = Class.forName("com.interview.chapter4.MyReflect");
         // 调用静态方法
        Method method = myClass.getMethod("staticMd");
        method.invoke(myClass);

        // 调用公共方法
        Object instance = myClass.newInstance();
        Method method2 = myClass.getMethod("publicMd");
        method2.invoke(instance);

        // 调用私有方法
        Object object = myClass.newInstance();
        Method method3 = myClass.getDeclaredMethod("privateMd");
        method3.setAccessible(true);
        method3.invoke(object);

    }
}

class MyReflect {
    // 静态方法
    public static void staticMd() {
        System.out.println("Static Method");
    }

    // 公共方法
    public void publicMd() {
        System.out.println("Public Method");
    }

    // 私有方法
    private void privateMd() {
        System.out.println("Private Method");
    }
}


