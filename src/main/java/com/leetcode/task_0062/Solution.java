package com.leetcode.task_0062;

public class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int x = Math.max(m, n);
        int y = Math.min(m, n);
        int[][] s = new int[x][y];
        for (int y1 = 1; y1 < y; y1++) {
            for (int x1 = y1; x1 < x; x1++) {
                if (y1 == 1) {
                    s[x1][y1] = x1 + 1;
                } else {
                    if (x1 == y1) {
                        s[x1][y1] = s[x1][y1 - 1] * 2;
                    } else {
                        s[x1][y1] = s[x1 - 1][y1] + s[x1][y1 - 1];
                    }
                }
            }
        }
        return s[x - 1][y - 1];
    }
}
