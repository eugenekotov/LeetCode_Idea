package com.leetcode.solved.task_0044;

public class MainClass_0044 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {

        System.out.println(solution.isMatch("qwertyuiop","a*v") == false);
        System.out.println(solution.isMatch("awertyviop","a*v") == false);
        System.out.println(solution.isMatch("awertyviop","a*v*") == true);
        System.out.println(solution.isMatch("qwaertyvuiop","*a*v*") == true);
        System.out.println(solution.isMatch("aqwaertyuiopv","*a*v*") == true);
        System.out.println(solution.isMatch("qwaevuiop","*a?v*") == true);
        System.out.println(solution.isMatch("a","aa") == false);
        System.out.println(solution.isMatch("aa","aa") == true);
        System.out.println(solution.isMatch("aa","a") == false);
        System.out.println(solution.isMatch("aa","*") == true);
        System.out.println(solution.isMatch("cb","?a") == false);
        System.out.println(solution.isMatch("aaaa","***a") == true);

        System.out.println(solution.isMatch("mississippi","m??*ss*?i*pi") == false);


    }
}
