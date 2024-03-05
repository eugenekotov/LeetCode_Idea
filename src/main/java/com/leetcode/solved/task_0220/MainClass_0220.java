package com.leetcode.solved.task_0220;

public class MainClass_0220 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int indexDiff = 3;
        int valueDiff = 0;
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
    }
}
