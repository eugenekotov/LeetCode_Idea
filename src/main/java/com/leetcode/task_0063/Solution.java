package com.leetcode.task_0063;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        int[][] s = new int[x][y];
        for (int y1 = 0; y1 < y; y1++) {
            for (int x1 = 0; x1 < x; x1++) {
                if (y1 == 0 || x1 == 0) {
                    if (obstacleGrid[x1][y1] == 0) {
                        if (x1 == 0 && y1 == 0) {
                            s[x1][y1] = 1;
                        } else if (y1 > 0) {
                            s[x1][y1] = s[x1][y1 - 1];
                        } else {
                            s[x1][y1] = s[x1 - 1][y1];
                        }
                    } else {
                        s[x1][y1] = 0;
                    }
                } else {
                    if (obstacleGrid[x1][y1] == 0) {
                        s[x1][y1] = s[x1][y1 - 1] + s[x1 - 1][y1];
                    } else {
                        s[x1][y1] = 0;
                    }
                }
            }
        }
        return s[x - 1][y - 1];
    }
}
