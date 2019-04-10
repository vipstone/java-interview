package com.interview.ch1;

/**
 * 第1章_02课_04 面试题部分源码
 */
public class Ch1_02_04 {
    public static void main(String[] args) {
        Integer age = 10;
        Integer age2 = 10;
        Integer age3 = 133;
        Integer age4 = 133;
        System.out.println((age == age2) + "," + (age3 == age4));
        Double num = 10d;
        Double num2 = 10d;
        Double num3 = 133d;
        Double num4 = 133d;
        System.out.println((num == num2) + "," + (num3 == num4));
    }
}
