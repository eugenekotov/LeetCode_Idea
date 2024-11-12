package com.leetcode.solved.task_0509;

public class Solution {

    public int fib(int n) {
        int fn = 1;
        int fnm1 = 0;
        for (int i = 0; i < n; i++) {
            int temp = fn;
            fn = fn + fnm1;
            fnm1 = temp;
        }
        return fnm1;
    }

//    public int fib(int n) {
//        return fib2(n, 0 , 1, 0);
//    }
//
//    private int fib2(int n, int level, int fn, int fn1) {
//        if (n == level) {
//            return fn1;
//        } else {
//            return fib2(n, level + 1, fn + fn1, fn);
//        }
//    }
}
