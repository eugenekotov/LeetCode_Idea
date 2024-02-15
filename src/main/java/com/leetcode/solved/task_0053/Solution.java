package com.leetcode.solved.task_0053;

public class Solution {

    /*
     * Dynamic
     */
    public int maxSubArray(int[] nums) {

        int maxSub = nums[0];
        int curSum = 0;

        for (int n : nums) {
            if (curSum < 0)
                curSum = 0;
            curSum += n;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub;

    }
}
