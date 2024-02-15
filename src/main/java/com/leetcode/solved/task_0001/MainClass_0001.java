package com.leetcode.solved.task_0001;

import java.util.Arrays;

public class MainClass_0001 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(checkSolution(new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 }));
        System.out.println(checkSolution(new int[] { 3, 2, 4 }, 6, new int[] { 1, 2 }));
        System.out.println(checkSolution(new int[] { 3, 3 }, 6, new int[] { 0, 1 }));
        System.out.println(checkSolution(new int[] { 0, 4, 3, 0 }, 0, new int[] { 0, 3 }));
        System.out.println(checkSolution(new int[] { -1, -2, -3, -4, -5 }, -8, new int[] { 2, 4 }));
    }

    private static boolean checkSolution(int[] nums, int target, int[] expectedResult) {
        int[] result = solution.twoSum(nums, target);
        return Arrays.equals(result, expectedResult);
    }

}
