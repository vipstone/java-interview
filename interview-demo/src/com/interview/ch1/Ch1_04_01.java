package com.interview.ch1;

public class Ch1_04_01 {

    private static int count = 0;

    public static void main(String[] args) {

        /*
         * 循环永远无法停下来的代码
         */
//        for (float i = 0; i != 1; i += 0.1) {
//            System.out.println(i);
//        }

        /*
         * 面试题部分代码
         **/
//        int i = 0;
//        int i2 = i++;
//        int i3 = ++i;
//        System.out.println(i2 + "|" + i3);

        /*
         * 面试题部分代码
         **/
//        int i = 0;
//        i = i++;
//        System.out.println("i的值是 " + i);

//        int i = 0;
//        int i2 = ++i;
//        System.out.println(i);
//        System.out.println(i2);

        /*
         * ++i 在多线程下产生的混乱
         **/
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100000; i++) {
//                    System.out.println("thread:" + this.getName() + ",count=" + (++count));
//                }
//            }
//
//        }.start();
//        new Thread() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100000; i++) {
//                    System.out.println("thread:" + this.getName() + ",count=" + (++count));
//                }
//            }
//
//        }.start();

        /*
         * ++i 基本使用
         **/
//        int i = 1;
//        int i2 = ++i; // ++i 相当于 i = 1+i;
//        System.out.println(i);  // 2
//        System.out.println(i2); // 2



    }

}
