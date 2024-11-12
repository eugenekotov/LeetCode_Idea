package com.leetcode.solved.task_0070;

public class Solution {

    int result;

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int nm1 = 2;
        int nm2 = 1;
        for (int i = 3; i <= n; i++) {
            nm1 = nm1 + nm2;
            nm2 = nm1 - nm2;
        }
        return nm1;
    }
}
