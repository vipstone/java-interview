package com.interview.ch1;

import com.sun.deploy.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 第一章 第七节 代码示例
 * @Author wanglei
 * @Date 2019/5/4
 * @Param
 * @return
 **/
public class Ch1_07 {
    public static void main(String[] args) {
        /*
         * 数组传参示例
         */
//        int[] arr = {2, 3, 4, 8};
//        change(arr);
//        System.out.println(arr[2]);

        /*
         * 字符串转数组
         */
//        String str = "laowang,stone,wanglei";
//        String[] arr = str.split(","); // 字符串转数组
//        System.out.println(arr[0]);

        /*
         * String To Array
         */
//        String[] arr = {"laowang", "stone", "wanglei"};
//        // 方式一：遍历
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < arr.length; i++) {
//            sb.append(arr[i]);
//            if (i != arr.length - 1)
//                sb.append(",");
//        }
//        System.out.println(sb.toString());
//        // 方式二：Arrays.toString
//        String str2 = Arrays.toString(arr);
//        System.out.println(str2);
//        // 方式三：StringUtils.join
//        String str3 = StringUtils.join(Arrays.asList(arr), ","); // 使用英文逗号分隔
//        System.out.println(str3);

        /*
         * 数组初始化
         */
//        // 初始化方式一
//        int[] arr = new int[5];
//        // 初始化方式二
//        int[] arr2 = new int[]{1, 2, 3, 4, 5};
//        // 初始化方式二的延伸版，可省略 new int[] 直接赋值
//        int[] arr3 = {1, 2, 3, 4, 5};

        /*
         * 数组遍历
         */
//        Integer[] arr = {2, 3, 6, 7, 9};
//        // 方式一：传统 for
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//        // 方式二：for each
//        for (int i : arr) {
//            System.out.println(i);
//        }
//        // 方式三：jdk 8 Limbda
//        Arrays.asList(arr).forEach(x -> System.out.println(x));

        /*
         * 初始化数组面试题
         */
        int[] intArr = new int[3];
        String[] StrArr = new String[3];
        System.out.println(intArr[1]);
        System.out.println(StrArr[1]);


    }

    private static void change(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] *= i;
            }
        }
    }


}
