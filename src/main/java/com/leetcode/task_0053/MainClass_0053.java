package com.leetcode.task_0053;

public class MainClass_0053 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        checkSolution(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, 6);
        checkSolution(new int[] { 1 }, 1);
        checkSolution(new int[] { 0 }, 0);
        checkSolution(new int[] { -1 }, -1);
        checkSolution(new int[] { -2147483647 }, -2147483647);

    }

    private static void checkSolution(int[] nums, int expected) {
        System.out.println(expected == solution.maxSubArray(nums));
    }

}
