package com.leetcode.solved.task_0066;

import com.leetcode.Utils;

public class MainClass_0066 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(Utils.arrayToString(solution.plusOne(new int[]{1, 2, 3}), ", "));
        System.out.println(Utils.arrayToString(solution.plusOne(new int[]{9}), ", "));
    }
}
