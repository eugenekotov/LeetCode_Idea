package com.leetcode.task_1306;

public class MainClass_1306 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        checkSolution(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 5, true);
        checkSolution(new int[] { 4, 2, 3, 0, 3, 1, 2 }, 0, true);
        checkSolution(new int[] { 3, 0, 2, 1, 2 }, 2, false);
    }

    private static void checkSolution(int[] arr, int start, boolean expexctedResult) {
        boolean result = solution.canReach(arr, start);
        System.out.println(result == expexctedResult);
    }

}
