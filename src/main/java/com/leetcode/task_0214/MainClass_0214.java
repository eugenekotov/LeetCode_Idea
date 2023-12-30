package com.leetcode.task_0214;

public class MainClass_0214 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        checkSolution("aacecaaa", "aaacecaaa");
        checkSolution("abcd", "dcbabcd");
        checkSolution("abbacd", "dcabbacd");
        checkSolution("aba", "aba");
        checkSolution("aaaaa","aaaaa");
        checkSolution("aaaaaa","aaaaaa");

    }

    private static void checkSolution(String s, String expeceted) {
        System.out.println(expeceted.equals(solution.shortestPalindrome(s)));
    }

}
