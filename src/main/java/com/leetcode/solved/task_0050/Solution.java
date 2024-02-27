package com.leetcode.solved.task_0050;

public class Solution {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        x = n > 0 ? x : 1/x;
        return myPow2(x, n);
    }

    private double myPow2(double x, int n) {
        if (n < 0) {
            n = -n;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            // Ціле число, ділемо на пари
            double result = myPow2(x, n / 2);
            return result * result;
        }
        return x * myPow2(x, n - 1);
    }

}
