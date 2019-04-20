package com.interview.ch1;

public class Ch1_04_02 {

    public static void main(String[] args) {
        /*
         * 循环永远无法停下来的代码
         */
        for (float i = 0; i != 1; i += 0.1) {
            System.out.println(i);
        }

        /*
         * i++ / ++i 结果比对
         */
//        int i = 0;
//        int i2 = i++;
//        int j = 0;
//        int j2 = ++j;
//        System.out.println("i2=" + i2);
//        System.out.println("j2=" + j2);

        /*
         * 浮点循环面试题
         */
//        for (float i = 0; i != 1; i += 0.1) {
//            System.out.println("hi");
//            if (i > 1) break;
//        }

        /*
         * 条件运算符
         */
//        String s = 3 > 1 ? "三大于一" : "三小于一";
//        System.out.println(s);

        /*
         * if 基础用法
         */
//        int i = 1;
//        if (i > 1) {
//            System.out.println("i大于一");
//        } else if (i == 1) {
//            System.out.println("i等于一");
//        } else {
//            System.out.println("其他");
//        }

        /*
         * while 面试题
         */
//        int i = 0;
//        while (i < 3) {
//            if (i == 2) {
//                return;
//            }
//            System.out.println(++i);
//        }

        /*
         * while 基本使用
         */
//        int i = 0;
//        while (i < 3) {
//            System.out.println(++i);
//        }

        /*
         * do/while 使用
         */
//        int i = 0;
//        do {
//            System.out.println(++i);
//        } while (i < 3);

        /*
         * for 基础使用
         */
//        for (int i = 0; i < 10; i++) {
//            System.out.println("i=" + i);
//        }

        /*
         * continue 使用
         */
//        for (int i = 1; i < 4; i++) {
//            if (i == 2) continue;
//            System.out.println("i=" + i);
//        }

        /*
         * switch 无 break 代码演示
         */
//        int i = 1;
//        switch (i) {
//            case 1:
//                System.out.println("等于1");
//            case 2:
//                System.out.println("等于2");
//            case 3:
//                System.out.println("等于3");
//            default:
//                System.out.println("等于其他");
//        }

    }

}
