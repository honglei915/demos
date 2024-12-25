package com.leicui.leetcode;

/**
 * Created by cuilei05 on 2024/12/24/14:45.
 */
public class Utils {
    public static void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
