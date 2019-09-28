package com.interview;

import java.util.Arrays;

/** 常见算法 */
public class Lesson7_4 {
  public static void main(String[] args) {
    // 冒泡排序调用
    int[] bubbleNums = {132, 110, 122, 90, 50};
    System.out.println("排序前：" + Arrays.toString(bubbleNums));
    bubbleSort(bubbleNums);
    System.out.println("排序后：" + Arrays.toString(bubbleNums));
  }

  /**
   * 冒泡排序
   *
   * @param nums 待排序数组
   */
  public static void bubbleSort(int[] nums) {
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
