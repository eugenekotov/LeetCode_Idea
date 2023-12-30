package com.leetcode.task_0055;

public class Solution {

    public boolean canJump(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0) {
            if (nums[i] == 0) {
                int j = i - 1;
                while (j >= 0 && nums[j] <= i - j) {
                    j--;
                }
                if (j < 0) {
                    return false;
                }
                i = j;
            } 
            i--;
        }
        return true;
    }

}
