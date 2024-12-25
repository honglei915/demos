package com.leicui.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by cuilei05 on 2024/12/24/11:34.
 */
class Hot100Test {

    @Test
    public void testMoveZeroes() {
        int[] nums = {0, 1, 0, 3, 12, 0};
        Hot100.moveZeroes(nums);
        Assertions.assertArrayEquals(new int[] {1, 3, 12, 0, 0, 0}, nums);


         nums = new int[]{1,0, 1, 0, 3, 12, 0};
        Hot100.moveZeroes(nums);
        Assertions.assertArrayEquals(new int[] {1,1, 3, 12, 0, 0, 0}, nums);

        nums = new int[] {0};
        Hot100.moveZeroes(nums);
        Assertions.assertArrayEquals(new int[] {0}, nums);

        nums = new int[] {1};
        Hot100.moveZeroes(nums);
        Assertions.assertArrayEquals(new int[] {1}, nums);
    }


    @Test
    public void testLongestConsecutive() {
        int[] nums = {100,4,200,1,3,2};
        Assertions.assertEquals( 4, Hot100.longestConsecutive(nums));


        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        Assertions.assertEquals( 9, Hot100.longestConsecutive(nums));

        nums = new int[]{0,0};
        Assertions.assertEquals( 1, Hot100.longestConsecutive(nums));
    }

    @Test
    void maxArea() {
    }
}