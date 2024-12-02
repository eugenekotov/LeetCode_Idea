package com.leetcode.solved.task_0150;

public class MainClass_0150 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(solution.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

}
