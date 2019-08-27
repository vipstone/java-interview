package com.learning.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class CarAop {
    @Before("execution(* com.learning.aop.Person.drive())")
    public void before() {
        System.out.println("巡视车体及周围情况");
        System.out.println("发动");
    }

    @After("execution(* com.learning.aop.Person.drive())")
    public void after() {
        System.out.println("熄火");
        System.out.println("锁车");
    }
}
