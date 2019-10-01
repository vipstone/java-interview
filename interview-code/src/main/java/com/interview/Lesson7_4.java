package com.interview;

import java.util.Arrays;

/**
 * 常见算法
 */
public class Lesson7_4 {
    public static void main(String[] args) {
        // 冒泡排序调用
        int[] bubbleNums = {132, 110, 122, 90, 50};
        System.out.println("冒泡排序前：" + Arrays.toString(bubbleNums));
        bubbleSort(bubbleNums);
        System.out.println("冒泡排序后：" + Arrays.toString(bubbleNums));

        // 选择排序调用
        int[] selectNums = {18, 1, 6, 27, 15};
        System.out.println("选择排序前：" + Arrays.toString(selectNums));
        selectSort(selectNums);
        System.out.println("选择排序后：" + Arrays.toString(selectNums));

        // 插入排序调用
        int[] insertNums = {18, 1, 6, 27, 15};
        System.out.println("插入排序前：" + Arrays.toString(insertNums));
        insertSort(insertNums);
        System.out.println("插入排序后：" + Arrays.toString(insertNums));

        // 快速排序调用
        int[] quickNums = {18, 1, 6, 27, 15};
        System.out.println("快速排序前：" + Arrays.toString(quickNums));
        quickSort(quickNums, 0, quickNums.length - 1);
        System.out.println("快速排序后：" + Arrays.toString(quickNums));

        // 堆排序调用
        int[] heapNums = {18, 1, 6, 27, 15};
        System.out.println("堆排序前：" + Arrays.toString(heapNums));
        heapSort(heapNums, heapNums.length);
        System.out.println("堆排序后：" + Arrays.toString(heapNums));


    }

    /**
     * 堆排序
     * @param nums 待排序数组
     * @param n    堆大小
     */
    private static void heapSort(int[] nums, int n) {
        int i, j, h, k, temp;
        // 将 nums[0,n-1] 建成大根堆
        for (i = n / 2 - 1; i >= 0; i--) {
            // 第 i 个节点，有右子树
            while (2 * i + 1 < n) {
                j = 2 * i + 1;
                if ((j + 1) < n) {
                    // 右左子树小于右子树，则需要比较右子树
                    if (nums[j] < nums[j + 1]) {
                        // 序号增加 1，指向右子树
                        j++;
                    }
                }
                if (nums[i] < nums[j]) {
                    // 交换数据
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    // 堆被破坏，重新调整
                    i = j;
                } else {
                    // 左右子节点均大，则堆未被破坏，不需要调整
                    break;
                }
            }
        }
        for (i = n - 1; i > 0; i--) {
            // 与第 i 个记录交换
            temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            k = 0;
            // 第 i 个节点有右子树
            while (2 * k + 1 < i) {
                j = 2 * k + 1;
                if ((j + 1) < i) {
                    // 右左子树小于右子树，则需要比较右子树
                    if (nums[j] < nums[j + 1]) {
                        // 序号增加 1，指向右子树
                        j++;
                    }
                }
                // todo:比较 i 与 j 为序号的数据
                if (nums[k] < nums[j]) {
                    // 交换数据
                    temp = nums[k];
                    nums[k] = nums[j];
                    nums[j] = temp;
                    // 堆被破坏，重新调整
                    k = j;
                } else {
                    // 左右子节点均大，则堆未被破坏，不需要调整
                    break;
                }
            }
            // 输出每步排序结果
            System.out.println("第" + (n - i) + "步排序：");
            System.out.println(Arrays.toString(nums));
        }
    }

    /**
     * 快速排序
     * @param nums 待排序数组
     */
    private static void quickSort(int[] nums, int left, int right) {
        int f, t;
        int ltemp = left;
        int rtemp = right;
        // 分解值
        f = nums[(left + right) / 2];
        while (ltemp < rtemp) {
            while (nums[ltemp] < f) {
                ++ltemp;
            }
            while (nums[rtemp] > f) {
                --rtemp;
            }
            if (ltemp <= rtemp) {
                t = nums[ltemp];
                nums[ltemp] = nums[rtemp];
                nums[rtemp] = t;
                --rtemp;
                ++ltemp;
            }
        }
        if (ltemp == rtemp) {
            ltemp++;
        }
        if (left < rtemp) {
            // 递归调用
            quickSort(nums, left, ltemp - 1);
        }
        if (right > ltemp) {
            // 递归调用
            quickSort(nums, rtemp + 1, right);
        }
    }

    /**
     * 插入排序
     * @param nums 待排序数组
     */
    private static void insertSort(int[] nums) {
        int j, k;
        for (int i = 1; i < nums.length; i++) {
            k = nums[i];
            j = i - 1;
            while (j >= 0 && k < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = k;
            System.out.println("I：" + i);
            System.out.println(Arrays.toString(nums));
        }
    }

    /**
     * 选择排序
     * @param nums 待排序数组
     */
    private static void selectSort(int[] nums) {
        int index;
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            if (index != i) {
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
            System.out.println("I：" + i);
            System.out.println(Arrays.toString(nums));
        }
    }

    /**
     * 冒泡排序
     * @param nums 待排序数组
     */
    private static void bubbleSort(int[] nums) {
        int temp;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            System.out.println("I：" + i);
            System.out.println(Arrays.toString(nums));
        }
    }
}
