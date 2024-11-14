package com.leetcode.solved.task_0054;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int x1 = 0; // current top line
        int x2 = matrix[0].length - 1;
        int y1 = 0;
        int y2 = matrix.length -1;
        while (x1 <= x2 && y1 <= y2) {
            int x = x1;
            int y = y1;
            // go right
            while (x <= x2) {
                result.add(matrix[y][x]);
                x++;
            }
            y1++;
            // go down
            x = x2;
            y = y1;
            while (y <= y2) {
                result.add(matrix[y][x]);
                y++;
            }
            x2--;
            // go left
            x = x2;
            y = y2;
            while (x1 <= x && y1 <= y2) {
                result.add(matrix[y][x]);
                x--;
            }
            y2--;
            // go up
            x = x1;
            y = y2;
            while (y1 <= y && x1 <= x2) {
                result.add(matrix[y][x]);
                y--;
            }
            x1++;
        }
        return result;
    }

}
