package com.leicui.leetcode;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by cuilei05 on 2024/12/24/11:32.
 */
@Slf4j
public class Hot100 {

    /**
     * 最长连续子序列
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<>(nums.length);

        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            // 不是起点
            if (set.contains(num - 1)) {
                // maxLength = Math.max(1, maxLength);
                continue;
            }
            int length = 1;
            while (set.contains(num++)) {
                length++;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }

    /**
     * 将0都一到右边，保持其他元素顺序不变
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

        log.info("nums:{}", nums);
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                Utils.swap(nums, index++, i);
            }
        }
    }

    /**
     * 将0都一到右边，保持其他元素顺序不变
     *
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {

        log.info("nums:{}", nums);
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
            log.info("index:{}, i:{}, nums:{}", index, i, nums);
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static int maxArea(int[] nums) {
        int maxArea = 0;

        int left = 0;
        int right = 0;

        while (left < right) {
            int area = (right - left) * Math.min(nums[left], nums[right]);
            if (area > maxArea) {
                maxArea = area;
            }

            // 谁短移动谁
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
