package com.leetcode.solved.task_1137;

public class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int nm1 = 1;
        int nm2 = 1;
        int nm3 = 0;
        for (int i = 3; i <= n; i++) {
            int nn = nm1 + nm2 + nm3;
            nm3 = nm2;
            nm2 = nm1;
            nm1 = nn;
        }
        return nm1;
    }
}
