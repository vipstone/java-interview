package com.learning.aop;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {
    public void drive() {
        System.out.println("开车");
    }
}
