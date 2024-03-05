package com.leetcode.solved.task_0219;

public class MainClass_0219 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(solution.containsNearbyDuplicate(nums, k));

//        int[] nums = {1, 2, 3, 1, 2, 3};
//        int k = 2;
//        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
}
