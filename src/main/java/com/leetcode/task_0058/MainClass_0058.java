package com.leetcode.task_0058;

public class MainClass_0058 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        checkSolution("Hello World", 5);
        checkSolution("Hello World d", 1);
    }

    private static void checkSolution(String word, int expectedResult) {
        System.out.println(solution.lengthOfLastWord(word) == expectedResult);
    }

}
