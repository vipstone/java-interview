package com.learning.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类
 **/
public class PersonTest {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-mvc.xml");
        Person landlord = context.getBean("person", Person.class);
        landlord.drive();
    }
}
