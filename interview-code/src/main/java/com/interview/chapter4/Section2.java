package com.interview.chapter4;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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

        // cglib 动态代理调用
        CglibProxy proxy = new CglibProxy();
        Panda panda = (Panda) proxy.getInstance(new Panda());
        panda.eat();
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


class Panda {
    public void eat() {
        System.out.println("The panda is eating");
    }
}

class CglibProxy implements MethodInterceptor {
    private Object target; // 代理对象

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 设置父类为实例类
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        Object result = methodProxy.invokeSuper(o, objects); // 执行方法调用
        System.out.println("调用后");
        return result;
    }
}