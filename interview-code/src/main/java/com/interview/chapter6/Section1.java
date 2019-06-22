package com.interview.chapter6;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Section1 {
    public static void main(String[] args) {
        // cglib 动态代理调用
        CglibProxy proxy = new CglibProxy();
        Panda panda = (Panda) proxy.getInstance(new Panda());
        panda.eat();
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