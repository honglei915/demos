package com.leicui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by cuilei05 on 2024/12/24/11:32.
 */
@Slf4j
public class Hot100 {

    /**
     * 两数之和
     * O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 1) {
            return null;
        }
        Map<Integer, Integer> allNums = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int another = target - num;
            Integer anotherIndex;
            // 另一个数在hash表里就是找到了
            if ((anotherIndex = allNums.get(another)) != null) {
                return new int[] {i, anotherIndex};
            }
            allNums.put(num, i);
        }
        return null;
    }

    /**
     * 三数之和
     * O(n^2)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];

            // 已经判断过了
            if (i >= 1 && num == nums[i - 1]) {
                continue;
            }

            // 最小的三个数加和大于0，跳过本次及后续判断
            if ((num + nums[i + 1] + nums[i + 2]) > 0) {
                break;
            }

            // 最大的三个数加和小于0，跳过本次判断
            if ((num + nums[nums.length - 1] + nums[nums.length - 2]) < 0) {
                continue;
            }

            int twoSum = 0 - num;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int numLeft = nums[left];
                int numRight = nums[right];
                int sum = numLeft + numRight;
                if (left > i + 1 && numLeft == nums[left - 1]) { // 过滤重复数据
                    left++;
                    continue;
                }
                if (sum == twoSum) {  // 找到了，双向推进
                    result.add(Arrays.asList(num, numLeft, numRight));
                    left++;
                    right--;
                } else if (sum < twoSum) {  // 小于，继续向右，右边的数更大
                    left++;
                } else {  // 大于，继续向左，左边的数更大
                    right--;
                }
            }
        }

        return result;
    }

    /**
     * 异位词分组
     * O(n)
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.emptyList();
        }

        if (strs.length == 1) {
            return Arrays.asList(Arrays.asList(strs[0]));
        }

        Map<String, List<String>> groups = new HashMap<>(strs.length / 2);
        Integer[] singnature = new Integer[26];
        for (String str : strs) {
            Arrays.fill(singnature, 0);
            for (char c : str.toCharArray()) {
                int index = c - 'a';
                singnature[index] = singnature[index] + 1;
            }

            String key = Arrays.stream(singnature).map(s -> s.toString()).collect(Collectors.joining());
            List<String> group = groups.get(key);
            if (group == null) {
                group = new ArrayList<>();
                groups.put(key, group);
            }
            group.add(str);
        }
        return new ArrayList<>(groups.values());
    }

    /**
     * 最长连续子序列
     * O(n)
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
     * O(n)
     */
    public static void moveZeroes(int[] nums) {

        log.info("nums:{}", nums);
        if (nums == null || nums.length == 0) {
            return;
        }

        // 标记
        int index = 0;

        // 从0开始，找到不为0的元素，和index交换
        for (int i = 0; i < nums.length; i++) {

            // 找到不为0的元素，和index交换，index++
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

    /**
     * 盛最多水的容器
     * O(n)
     */
    public static int maxArea(int[] nums) {
        int maxArea = 0;

        int left = 0;
        int right = 0;

        while (left < right) {
            // 两者最短的作为高，距离作为宽，计算面积
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

    /**
     * 接雨水
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int water = 0;
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        // 从两边向中间
        while (left < right) {
            // 前缀最大值
            leftMax = Math.max(leftMax, height[left]);
            // 后缀最大值
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax <= rightMax) { // 前缀最大值小，那么left的上限就是前缀最大值
                water += leftMax - height[left];
                left++;
            } else { // 后最大值小，那么right的上限就是后缀最大值
                water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
