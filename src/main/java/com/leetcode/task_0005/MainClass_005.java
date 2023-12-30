package com.leetcode.task_0005;

import java.util.Arrays;

public class MainClass_005 {

    private static Solution solution = new Solution();
    
    public static void main(String[] args) {
        checkSolution("babad", new String[] {"bab","aba"});
        checkSolution("cbbd", new String[] {"bb"});
        checkSolution("a", new String[] {"a"});
        checkSolution("ac", new String[] {"a"});
        checkSolution("bb", new String[] {"bb"});
        checkSolution("aaaa", new String[] {"aaaa"});
    }

    private static void checkSolution(String s, String[] expectedResults) {
        String result = solution.longestPalindrome(s);
        System.out.println(Arrays.asList(expectedResults).contains(result));
    }

}
