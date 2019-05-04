package com.interview.ch1;

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

        String[] arr = "hi,laowang".split(",");
        System.out.println(arr[0]);

    }

    private static void change(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] *= i;
            }
        }
    }


}
