package com.leicui.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SortTest {

    @Test
    void quickSort_emptyArray() {
        int[] nums = {};
        Sort.quickSort(nums);
        assertArrayEquals(new int[] {}, nums);
    }

    @Test
    void quickSort_singleElement() {
        int[] nums = {1};
        Sort.quickSort(nums);
        assertArrayEquals(new int[] {1}, nums);
    }

    @Test
    void quickSort_twoElements() {
        int[] nums = {2, 1};
        Sort.quickSort(nums);
        assertArrayEquals(new int[] {1, 2}, nums);
    }

    @Test
    void quickSort_threeElements() {
        int[] nums = {3, 1, 2};
        Sort.quickSort(nums);
        assertArrayEquals(new int[] {1, 2, 3}, nums);
    }

    @Test
    void quickSort_negativeElements() {
        int[] nums = {-1, -2, -3};
        Sort.quickSort(nums);
        assertArrayEquals(new int[] {-3, -2, -1}, nums);
    }

    @Test
    void quickSort_mixedElements() {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, -1, -9, 0};
        Sort.quickSort(nums);
        assertArrayEquals(new int[] {-9, -1, 0, 1, 1, 2, 3, 4, 5, 6, 9}, nums);
    }

    @Test
    void quickSort_alreadySorted() {
        int[] nums = {1, 2, 3, 4, 5};
        Sort.quickSort(nums);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, nums);
    }

    @Test
    void quickSort_reverseSorted() {
        int[] nums = {5, 4, 3, 2, 1};
        Sort.quickSort(nums);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, nums);
    }
}