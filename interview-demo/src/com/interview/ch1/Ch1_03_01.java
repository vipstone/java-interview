package com.interview.ch1;


import java.util.ArrayList;
import java.util.List;

/**
 * 第1章_03课_01 示例代码
 */
public class Ch1_03_01 {
    public static void main(String[] args) {
        /**
         * 模块代码
         */
//        String s1 = "laowang";
//        String s2 = s1;
//        String s3 = new String(s1);
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);

        /**
         * 模块代码
         */
//        String s1 = "hi," + "lao" + "wang";
//        String s2 = "hi,";
//        s2 += "lao";
//        s2 += "wang";
//        String s3 = "hi,laowang";
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s2 == s3);


        /**
         * 模块代码
         */
//        String str = new String("laowang");
//        change(str);
//        System.out.println(str);

        /**
         * 模块代码
         */
//        StringBuffer sb = new StringBuffer("hi,");
//        changeSb(sb);
//        System.out.println(sb);

        /**
         * 模块代码
         */
//        String str = "abcdef";
//        // 结果：cdef（从下标为2的开始截取到最后，包含开始下标）
//        System.out.println(str.substring(2));
//        // 结果：cd（从下标为2的开始截取到下标为4的，包含开始下标不包含结束下标）
//        System.out.println(str.substring(2, 4));

        /**
         * 模块代码
         */
//        String str = String.format("我叫%s，今年%d岁，喜欢%s", "老王", 30, "读书");
//        System.out.println(str);

        /**
         * 模块代码
         */
//        String s1 = "hi," + "lao" + "wang";
//        String s2 = "hi,";
//        s2 += "lao";
//        s2 += "wang";
//        String s3 = "hi,laowang";
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.equals(s3));
//        System.out.println(s2.equals(s3));

        /**
         * 模块代码
         */
//        String s1 = "Hi,laowang";
//        String s2 = "hi,laowang";
//        System.out.println(s1.equals(s2)); // false
//        System.out.println(s1.equalsIgnoreCase(s2)); // true

        /**
         * 模块代码
         */
//        StringBuilder sb = new StringBuilder("lao");
//        // 添加字符串到尾部
//        sb.append("wang"); // laowang
//        // 插入字符串到到当前字符串下标的位置
//        sb.insert(0, "hi,"); // hi,laowang
//        // 修改字符中某个下标的值
//        sb.setCharAt(0, 'H'); // Hi,laowang
//        System.out.println(sb);

        /**
         * 模块代码
         */
//        String str = "abcdef";
//        System.out.println(str.substring(3, 3));
        /**
         * 模块代码
         */
//        String s1 = "1";
//        String s2 = "1";
//        System.out.println(s1 == s2);

        String s1 = "hi";
        String s2 = new String("hi").intern();
        System.out.println(s1 == s2);
    }

    /**
     * 修改 StringBuffer
     *
     * @param sb
     */
    public static void changeSb(StringBuffer sb) {
        sb.append("laowang");
    }

    /**
     * 修改字符串
     *
     * @param str
     */
    public static void change(String str) {
        str = "xiaowang";
    }

}
