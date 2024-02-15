package com.leetcode.solved.task_0065;

import java.util.Arrays;

public class MainClass_0065 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {

//        String[] validArray = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
//        String[] invalidArray = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
//
//        Arrays.stream(validArray).forEach(value -> {
//            System.out.println(value + " " + (solution.isNumber(value) ? "correct" : "incorrect"));
//        });
//        Arrays.stream(invalidArray).forEach(value -> {
//            System.out.println(value + " " + (!solution.isNumber(value) ? "correct" : "incorrect"));
//        });

        String[] invalidArray = {"."};

        Arrays.stream(invalidArray).forEach(value -> {
            System.out.println(value + " " + (!solution.isNumber(value) ? "correct" : "incorrect"));
        });


    }
}
