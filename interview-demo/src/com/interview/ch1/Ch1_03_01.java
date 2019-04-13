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

        StringBuffer sb = new StringBuffer("hi,");
        changeSb(sb);
        System.out.println(sb);

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
