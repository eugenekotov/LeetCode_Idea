package com.leetcode.solved.task_0053;

public class Solution2 {

    /*
     * Dynamic
     */
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int previousValue = 0;
        for (int x1 = 0; x1 < nums.length; x1++) {
            for (int x2 = x1; x2 < nums.length; x2++) {
                int value;
                if (x1 < x2) {
                    value = previousValue + nums[x2];
                } else if (x1 == x2) {
                    value = nums[x1];
                } else {
                    throw new IllegalArgumentException();
                }
                if (value > maxSum) {
                    maxSum = value;
                }
                previousValue = value;
            }
        }
        return maxSum;
    }
}
