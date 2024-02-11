package com.leetcode.task_0062;

import java.util.Arrays;

public class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int x = Math.max(m, n);
        int y = Math.min(m, n);
        int[][] s = new int[x + 1][y + 1];
        for (int y1 = 2; y1 <= y; y1++) {
            for (int x1 = y1; x1 <= x; x1++) {
                if (y1 == 2) {
                    s[x1][y1] = x1;
                } else {
                    if (x1 == y1) {
                        s[x1][y1] = s[x1][y1 - 1] * 2;
                    } else {
                        s[x1][y1] = s[x1 - 1][y1] + s[x1][y1 - 1];
                    }
                }
            }
        }
        return s[x][y];
    }

//    public int uniquePaths2(int m, int n) {
//        if (m < n) {
//            int a = m;
//            m = n;
//            n = a;
//        }
//        // m >= n
//        int res1 = uniquePaths2(n, n);
//        if (m == 1 || n == 1) {
//            return 1;
//        }
//        if (m == 2) {
//            return n;
//        }
//        if (n == 2) {
//            return m;
//        }
//        if (m == n) {
//            return uniquePaths2(m - 1, n) * 2;
//        }
//        return uniquePaths2(m - 1, n) + uniquePaths2(m, n - 1);
//    }
}
