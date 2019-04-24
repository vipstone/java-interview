package com.interview.ch1;

/**
 * @Description 第一章 第5节 源码
 * @Author wanglei
 * @Date 2019/4/22
 **/
public class Ch1_05_01 {
    public static void main(String[] args) {


        /*
         * finally 也发生的异常
         */
        try {
            System.out.println("try");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            int k = 3 / 0;
            System.out.println("finally");
        }
        System.out.println("main");

        /*
         * try/finally
         */
//        try {
//            int i = 10 / 0;
//        } finally {
//            System.out.println("last");
//        }


    }
}
