package com.leetcode.task_0303;

public class NumArray {

    private int[] nums;
    private int[] sums;

    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length / 2];
        for (int i = 0; i < sums.length; i++) {
            sums[i] = nums[i*2] + nums[i*2 + 1];
        }
    }

    public int sumRange(int i, int j) {
        int result = 0;
        int i2 = i / 2;
        if (i % 2 > 0) {
            result = nums[i];
            i2++;
        }
        int j2 = j / 2;
        if (j % 2 == 0) {
            result = result + nums[j];
            j2--;
        }
        if (sums.length > 0) {
            for (int k = i2; k <= j2; k++) {
                result = result + sums[k];
            }
        }
        return result;
    }
}
