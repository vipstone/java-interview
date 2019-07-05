package com.interview;

public class Lesson1_2 {
    public static void main(String[] args) {
        /************* 极值查询打印 ************/
        System.out.println(String.format("Byte：%d ~ %d", Byte.MIN_VALUE, Byte.MAX_VALUE));  // -128 ~ 127
        System.out.println(String.format("Int：%d ~ %d", Integer.MIN_VALUE, Integer.MAX_VALUE)); // -2147483648 ~ 2147483647
        /********** 高频区缓存范围 -128~127 测试 ************/
        Integer num1 = 127;
        Integer num2 = 127;
        System.out.println("Integer等于127时：" + (num1 == num2)); // true
        Integer num3 = 128;
        Integer num4 = 128;
        System.out.println("Integer等于128时：" + (num3 == num4)); // false
        System.out.println("Integer等于128时 equals：" + num3.equals(num4)); // true
        /********* Integer 高频区域的最大值演示 *********/
        Integer i1 = -128;
        Integer i2 = -128;
        System.out.println("值为-128 => " + (i1 == i2));
        Integer i3 = 666;
        Integer i4 = 666;
        System.out.println("值为666 => " + (i3 == i4));
        Integer i5 = 667;
        Integer i6 = 667;
        System.out.println("值为667 => " + (i5 == i6));
        /************* 面试题示例代码 *************/
        Integer age1 = 10;
        Integer age2 = 10;
        Integer age3 = 133;
        Integer age4 = 133;
        Double d1 = 10d;
        Double d2 = 10d;
        Double d3 = 133d;
        Double d4 = 133d;
        System.out.println((age1 == age2) + "," + (age3 == age4));
        System.out.println((d1 == d2) + "," + (d3 == d4));
    }
}
