package com.leetcode.solved.task_0231;

public class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        } else if (n == 1 || n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return isPowerOfTwo(n / 2);
        } else {
            return false;
        }
    }
}
