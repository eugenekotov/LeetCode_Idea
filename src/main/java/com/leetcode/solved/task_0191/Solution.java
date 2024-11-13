package com.leetcode.solved.task_0191;

public class Solution {

    public int hammingWeight(int n) {
        int result = 0;
        while (n > 1) {
            if (n % 2 > 0) {
                result++;
            }
            n = n / 2;
        }
        return result + 1;
    }

    public int hammingWeight2(int n) {
        int result = 0;
        long bit = 0;
        while (bit < n) {
            if (bit == 0) {
                bit =1;
            } else {
                bit = bit << 1;
            }
            if ((n & bit) > 0) {
                result++;
            }
        }
        return result;
    }


}
