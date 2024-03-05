package com.leetcode.solved.task_0048;

public class Solution {

    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length / 2; row++) {
            int maxIndex = matrix.length - row - 1;
            for (int col = row; col < matrix.length - row - 1; col++) {
                int tempValue = matrix[row][col];
                matrix[row][col] = matrix[row + maxIndex - col][row];
                matrix[row + maxIndex - col][row] = matrix[maxIndex][row + maxIndex - col];
                matrix[maxIndex][row + maxIndex - col] = matrix[col][maxIndex];
                matrix[col][maxIndex] = tempValue;
            }
        }
    }
}
