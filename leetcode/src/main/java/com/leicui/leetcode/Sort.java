package com.leicui.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by cuilei05 on 2024/12/27/19:17.
 */
@Slf4j
public class Sort {

    /**
     * 快速排序
     *
     * @param nums
     */
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        // 只有一个元素，结束
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;

        // 基准点
        int base = nums[start];

        while (left < right) {

            // 向左移动指针，大于基准值的不用东
            while (left < right && nums[right] >= base) {
                right--;
            }
            // 找到小于基准值的，交换到left位置
            nums[left] = nums[right];

            // 向右移动指针，小于基准值的不用动
            while (left < right && nums[left] <= base) {
                left++;
            }
            // 找到大于基准值的，交换到right位置
            nums[right] = nums[left];
        }

        // 基准值放到相遇的位置
        nums[left] = base;

        // 以相遇的地方切开，对两边进行递归
        quickSort(nums, start, left);
        quickSort(nums, left + 1, end);
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
