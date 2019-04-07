package com.interview.ch1;

/*
 * 第1章_02课_02 示例代码
 */
public class Ch1_02_02 {
    public static void main(String[] args) {
        // Integer 高频区缓存范围 -128~127
        Integer num1 = 127;
        Integer num2 = 127;
        // Integer 取值 127 结果为 true（值127 num1==num2 => true）
        System.out.println("值127 num1==num2 => " + (num1 == num2));
        Integer num3 = 128;
        Integer num4 = 128;
        // Integer 取值 128 结果为 false（值128 num3==num4 => false）
        System.out.println("值128 num3==num4 => " + (num3 == num4));
    }
}
