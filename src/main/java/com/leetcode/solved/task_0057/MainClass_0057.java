package com.leetcode.solved.task_0057;

import com.leetcode.Utils;

public class MainClass_0057 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(Utils.arrayToString(solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Utils.arrayToString(solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8})));
        System.out.println(Utils.arrayToString(solution.insert(new int[][]{{1, 5}}, new int[]{0, 0})));
        System.out.println(Utils.arrayToString(solution.insert(new int[][]{{0, 0}}, new int[]{1, 5})));
    }
}
