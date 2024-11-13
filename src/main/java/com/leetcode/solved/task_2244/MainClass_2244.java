package com.leetcode.solved.task_2244;

public class MainClass_2244 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        System.out.println(solution.minimumRounds(new int[]{2, 3, 3}));
        System.out.println(solution.minimumRounds(new int[]{9, 9, 11, 9, 11, 22, 22, 22, 55, 22, 55}));
        System.out.println(solution.minimumRounds(new int[]{5, 5, 5, 5}));
    }
}
