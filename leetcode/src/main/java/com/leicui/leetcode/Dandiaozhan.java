package com.leicui.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by cuilei05 on 2024/12/25/14:45.
 */
public class Dandiaozhan {

    /**
     * 从左到右
     */
    public static int[] dailyTemperature(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        Arrays.fill(result, 0);
        for (int i = 0; i < temperatures.length; i++) {
            int current = temperatures[i];
            while (!stack.isEmpty()) {
                Integer peek = stack.peek();
                if (!(current > temperatures[peek])) {
                    break;
                }
                // 如果当前元素比栈顶元素大，那么当前元素是栈顶元素的下一个更高温度的索引，栈顶元素出栈，并将索引差值赋值给结果数组的对应位置。
                result[peek] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    public static int[] dailyTemperature1(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int current = temperatures[i];

            // 弹出所有比当前温度小的元素
            while (!stack.isEmpty() && current >= temperatures[stack.peek()]) {
                stack.pop();
            }
            // 栈顶元素即为下一个更高温度的索引，如果为空则说明没有更高的温度
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            // 将当前索引压入栈中，以便后续比较
            stack.push(i);
        }
        return result;
    }
}
