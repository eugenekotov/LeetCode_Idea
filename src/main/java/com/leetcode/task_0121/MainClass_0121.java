package com.leetcode.task_0121;

public class MainClass_0121 {

    private static Solution solution = new Solution();
    
    public static void main(String[] args) {
        checkSolution(new int[] {7,1,5,3,6,4} , 5);

    }

    private static void checkSolution(int[] prices, int expectedResult) {
        int result = solution.maxProfit(prices);
        System.out.println(result == expectedResult);
    }

}
