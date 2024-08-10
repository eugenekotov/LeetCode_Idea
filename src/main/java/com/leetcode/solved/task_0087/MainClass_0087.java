package com.leetcode.solved.task_0087;

public class MainClass_0087 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.isScramble("great", "rgeat") == true);
        System.out.println(solution.isScramble("abcde", "caebd") == false);
        System.out.println(solution.isScramble("abcdbdacbdac", "bdacabcdbdac") == true);
        System.out.println(solution.isScramble("abcd", "dabc") == true);
//        System.out.println(solution.isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd"));
    }
}
