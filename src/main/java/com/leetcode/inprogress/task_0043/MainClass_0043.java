package com.leetcode.inprogress.task_0043;

public class MainClass_0043 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.multiply("2","3").equals("6"));
        System.out.println(solution.multiply("123","456").equals("56088"));
        System.out.println(solution.multiply("408","5").equals("2040"));
        System.out.println(solution.multiply("0","0").equals("0"));
        System.out.println(solution.multiply("123","0").equals("0"));
    }

}
