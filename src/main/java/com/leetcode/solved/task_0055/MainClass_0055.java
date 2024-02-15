package com.leetcode.solved.task_0055;

public class MainClass_0055 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        checkSolution(new int[] { 2, 3, 1, 1, 4 }, true);
        checkSolution(new int[] { 3, 2, 1, 0, 4 }, false);
        checkSolution(new int[] { 0, 2, 1, 1, 4 }, false);
    }

    private static void checkSolution(int[] nums, boolean expectedResult) {
        System.out.println(expectedResult == solution.canJump(nums));
    }

}
