package com.leetcode.solved.task_0048;

import com.leetcode.Utils;

public class MainClass_0048 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.print(Utils.arrayToString(matrix) + " => ");
        solution.rotate(matrix);
        System.out.println(Utils.arrayToString(matrix));

//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.print(Utils.arrayToString(matrix) + " => ");
//        solution.rotate(matrix);
//        System.out.println(Utils.arrayToString(matrix));

//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        System.out.println(Utils.arrayToString(matrix) + " => ");
//        solution.rotate(matrix);
//        System.out.println(Utils.arrayToString(matrix));

//        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
//        System.out.print(Utils.arrayToString(matrix) + " => ");
//        solution.rotate(matrix);
//        System.out.println(Utils.arrayToString(matrix));

    }
}
