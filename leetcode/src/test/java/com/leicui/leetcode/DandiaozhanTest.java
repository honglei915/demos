package com.leicui.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Created by cuilei05 on 2024/12/25/14:51.
 */
class DandiaozhanTest {

    @Test
    public void dailyTemperature() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, Dandiaozhan.dailyTemperature(temperatures));


        temperatures = new int[] {89,62,70,58,47,47,46,76,100,70};
        expected = new int[] {8,1,5,4,3,2,1,1,0,0};
        assertArrayEquals(expected, Dandiaozhan.dailyTemperature(temperatures));

        temperatures = new int[] {30, 40, 50, 60};
        expected = new int[] {1, 1, 1, 0};
        assertArrayEquals(expected, Dandiaozhan.dailyTemperature(temperatures));

        temperatures = new int[] {30, 60, 90};
        expected = new int[] {1, 1, 0};
        assertArrayEquals(expected, Dandiaozhan.dailyTemperature(temperatures));
    }
}