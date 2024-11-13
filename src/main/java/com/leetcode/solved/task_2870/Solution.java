package com.leetcode.solved.task_2870;

import java.util.Arrays;

public class Solution {

    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int priorValue = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (priorValue != nums[i]) {
                if (count == 1) {
                    return -1;
                } else if (count > 1) {
                    result = result + count / 3 + (count % 3 != 0 ? 1 : 0);
                }
                priorValue = nums[i];
                count = 1;
            } else {
                count++;
            }
        }
        if (count == 1) {
            return -1;
        } else if (count > 1) {
            result = result + count / 3 + (count % 3 != 0 ? 1 : 0);
        }
        return result;
    }
}
