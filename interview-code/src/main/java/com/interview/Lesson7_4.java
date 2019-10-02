package com.interview;

import java.util.Arrays;

/**
 * 算法
 */
public class Lesson7_4 {
    public static void main(String[] args) {
        // 二分法查找
        int[] binaryNums = {1, 6, 15, 18, 27, 50};
        int findValue = 27;
        int binaryResult = binarySearch(binaryNums, 0, binaryNums.length - 1, findValue);
        System.out.println("元素第一次出现的位置（从0开始）：" + binaryResult);

        // 斐波那契数列
        int fibonacciIndex = 7;
        int fibonacciResult = fibonacci(fibonacciIndex);
        System.out.println("下标(从0开始)" + fibonacciIndex + "的值为：" + fibonacciResult);

        // 兔子的总对数
        int rabbitNumber = fibonacci(12);
        System.out.println("第 12 个月兔子的总对数是：" + rabbitNumber);

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
     * 斐波那契数列
     * @param index 斐波那契数列的下标（从0开始）
     * @return int
     */
    private static int fibonacci(int index) {
        if (index == 0 || index == 1) {
            return index;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }

    /**
     * 二分查找，返回该值第一次出现的位置（下标从0开始）
     * @param nums      查询数组
     * @param start     开始下标
     * @param end       结束下标
     * @param findValue 要查找的值
     * @return int
     */
    private static int binarySearch(int[] nums, int start, int end, int findValue) {
        if (start <= end) {
            // 中间位置
            int middle = (start + end) / 2;
            // 中间的值
            int middleValue = nums[middle];
            if (findValue == middleValue) {
                // 等于中值直接返回
                return middle;
            } else if (findValue < middleValue) {
                // 小于中值，在中值之前的数据中查找
                return binarySearch(nums, start, middle - 1, findValue);
            } else {
                // 大于中值，在中值之后的数据中查找
                return binarySearch(nums, middle + 1, end, findValue);
            }
        }
        return -1;
    }

    /**
     * 堆排序
     * @param nums 待排序数组
     * @param n    堆大小
     */
    private static void heapSort(int[] nums, int n) {
        int i, j, k, temp;
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
                // 比较 i 与 j 为序号的数据
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
        // 分界值
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
