package com.interview.ch1;

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        int[] arr = {2, 3, 4, 8};
        change(arr);
        System.out.println(arr[2]);

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
//        int[] intArr = new int[3];
//        String[] StrArr = new String[3];
//        System.out.println(intArr[1]);
//        System.out.println(StrArr[1]);

        /*
         * Arrays.fill 填充值
         */
//        int[] arr = new int[5];
//        // 给数组的所有元素分配一个值
//        Arrays.fill(arr, 9);
//        for (int i : arr) {
//            System.out.println(i);
//        }

        // Arrays.sort 排序
//        String[] strArr = {"dog", "cat", "pig", "bird"};
//        Arrays.sort(strArr);
//        System.out.println(Arrays.toString(strArr));

        /*
         * 数组值比较
         */
//        String[] strArr = {"dog", "cat", "pig", "bird"};
//        String[] strArr2 = {"dog", "cat", "pig", "bird"};
//        System.out.println(Arrays.equals(strArr, strArr2));
//        System.out.println(strArr.equals(strArr2));
//        System.out.println(strArr == strArr2);

        /*
         * 二分法查询元素 Arrays.binarySearch 的正确使用方式
         */
//        String[] arr = {"dog", "cat", "pig", "bird"};
//        Arrays.sort(arr);
//        // 使用二分法查询数组元素，查询到返回元素的索引位置，查找不到返回-1
//        int result = Arrays.binarySearch(arr, "bird");
//        System.out.println(result == -1);

        /*
         * 二维数组的使用
         */
//        // 声明二维数组
//        int[][] arr = new int[2][4];
//        //循环二维数组
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                // 二维数组赋值
//                arr[i][j] = j;
//            }
//        }
//        // 二维数组取值
//        System.out.println(arr[0][1]);
//        // 打印二维数组
//        System.out.println(Arrays.toString(arr[0]));
//        System.out.println(Arrays.toString(arr[1]));

        /*
         * 数组拷贝
         */
//        int[] arr = {3, 4, 9};
//        int[] arr2 = Arrays.copyOf(arr, 5);
//        System.out.println(Arrays.toString(arr2));

        /*
         * 数组填充
         */
//        int[] arr = new int[10];
//        arr[0] = 3;
//        Arrays.fill(arr, 6);
//        System.out.println(Arrays.toString(arr));

        /*
         * 数组合并
         */
//        int[] arr = {2, 8, 13, 11, 6, 7};
//        int[] arr2 = {66, 88};
//        // 合并数组
//        int[] arr3 = org.apache.commons.lang3.ArrayUtils.addAll(arr, arr2);
//        System.out.println(Arrays.toString(arr3));

        /*
         * 数组正序和逆序
         */
//        int[] arr = {2, 8, 13, 11, 6, 7};
//        // 数组正序（排序）
//        Arrays.sort(arr);
//        // 数组逆序
//        org.apache.commons.lang3.ArrayUtils.reverse(arr);
//        System.out.println(Arrays.toString(arr));

        /*
         * 字符串数组某个值查询
         */
//        String[] arr = {"doc", "pig", "cat"};
//        // 方式一：Arrays.asList(array).contains
//        boolean bool = Arrays.asList(arr).contains("cat");
//        System.out.println(bool);
//        // 方式二：Arrays.binarySearch
//        Arrays.sort(arr);
//        boolean bool2 = Arrays.binarySearch(arr, "cat") > -1;
//        System.out.println(bool2);

        /*
         * Arrays.binarySearch 使用
         */
//        int[] arr = {1, 3, 4, 5};
//        // Arrays.binarySearch() 使用二分法查询某值
//        int index = Arrays.binarySearch(arr, 5);
//        System.out.println(index);

        /*
         * 冒泡排序
         */
//        int[] arr = {2, 8, 13, 11, 6, 7};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    // 元素交换
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        System.out.println("排序后：" + Arrays.toString(arr));

        /*
         * 选择排序
         */
//        int[] arr = {2, 8, 13, 11, 6, 7};
//        System.out.println("排序前：" + Arrays.toString(arr));
//        for (int i = 0; i < arr.length; i++) {
//            int lowerIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                // 找出最小的一个索引
//                if (arr[j] < arr[lowerIndex]) {
//                    lowerIndex = j;
//                }
//            }
//            // 交换
//            int temp = arr[i];
//            arr[i] = arr[lowerIndex];
//            arr[lowerIndex] = temp;
//        }
//        System.out.println("排序后：" + Arrays.toString(arr));

        /*
         * 数组转集合
         */
//        String[] strArr = {"cat", "dog"};
//        List list = Arrays.asList(strArr);
//        System.out.println(list);

        /*
         * 集合转数组
         */
//        List<String> list = new ArrayList<String>();
//        list.add("cat");
//        list.add("dog");
//        // 集合转换为数组
//        String[] arr = list.toArray(new String[list.size()]);
//        System.out.println(Arrays.toString(arr));


    }

    private static void change(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] *= i;
            }
        }
    }


}
