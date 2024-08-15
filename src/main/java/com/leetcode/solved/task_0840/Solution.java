package com.leetcode.solved.task_0840;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int numMagicSquaresInside(int[][] grid) {
        // make restricted
        Map<Integer, Set<Integer>> restricted = new HashMap<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] > 9 || grid[row][col] < 1) {
                    // Add restricted
                    for (int iRow = 0; iRow < 3 && row - iRow >= 0; iRow++) {
                        int checkRow = row - iRow;
                        Set<Integer> cols = restricted.get(checkRow);
                        if (cols == null) {
                            cols = new HashSet<>();
                            restricted.put(checkRow, cols);
                        }
                        for (int iCol = 0; iCol < 3 && col - iCol >= 0; iCol++) {
                            int checkCol = col - iCol;
                            cols.add(checkCol);
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int row = 0; row < grid.length - 2; row++) {
            for (int col = 0; col < grid[0].length - 2; col++) {
//                // Check for restricted
                Set<Integer> cols = restricted.get(row);
                if (cols != null && cols.contains(col)) {
                    continue;
                }
                if (check(grid, row, col)) {
                    result++;
                }
                //
            }
        }
        return result;
    }

    private boolean check(int[][] grid, int row, int col) {
        Set<Integer> digits = new HashSet<>();
        int sum_r1 = 0;
        int sum_r2 = 0;
        int sum_r3 = 0;
        int sum_c1 = 0;
        int sum_c2 = 0;
        int sum_c3 = 0;
        int sum_d1 = 0;
        int sum_d2 = 0;
        for (int i = 0; i < 3; i++) {
            if (digits.contains(grid[row + i][col + 0]) || digits.contains(grid[row + i][col + 1]) || digits.contains(grid[row + i][col + 2])) {
                return false;
            }
            digits.add(grid[row + i][col + 0]);
            digits.add(grid[row + i][col + 1]);
            digits.add(grid[row + i][col + 2]);
            sum_r1 = sum_r1 + grid[row + 0][col + i];
            sum_r2 = sum_r2 + grid[row + 1][col + i];
            sum_r3 = sum_r3 + grid[row + 2][col + i];
            sum_c1 = sum_c1 + grid[row + i][col + 0];
            sum_c2 = sum_c2 + grid[row + i][col + 1];
            sum_c3 = sum_c3 + grid[row + i][col + 2];
            sum_d1 = sum_d1 + grid[row + i][col + i];
            sum_d2 = sum_d2 + grid[row + 2 - i][col + i];
        }
        if (digits.size() == 9 && sum_r1 == sum_r2 && sum_r1 == sum_r3 && sum_r1 == sum_c1 && sum_r1 == sum_c2 && sum_r1 == sum_c3 && sum_r1 == sum_d1 && sum_r1 == sum_d2) {
            return true;
        }
        return false;
    }

}
