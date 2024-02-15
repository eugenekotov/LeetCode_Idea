package com.leetcode.solved.task_0064;

public class Solution {

    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] s = new int[x][y];
        for (int y1 = 0; y1 < y; y1++) {
            for (int x1 = 0; x1 < x; x1++) {
                if (y1 == 0 && x1 == 0) {
                    s[x1][y1] = grid[x1][y1];
                } else if (x1 == 0) {
                    s[x1][y1] = grid[x1][y1] + s[x1][y1 - 1];
                } else if (y1 == 0) {
                    s[x1][y1] = grid[x1][y1] + s[x1 - 1][y1];
                } else {
                    s[x1][y1] = grid[x1][y1] + Math.min(s[x1][y1 - 1], s[x1 - 1][y1]);
                }
            }
        }
        return s[x - 1][y - 1];
    }
}
