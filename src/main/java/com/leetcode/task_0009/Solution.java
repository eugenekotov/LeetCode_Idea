package com.leetcode.task_0009;

public class Solution {
    public boolean isPalindrome(int x) {
        if (Integer.signum(x) < 0) {
            return false;
        }
        String result = "";
        if (x == 0) {
            result = "0";
        }
        while (x != 0) {
            int digit = x % 10;
            result = digit + result;
            x = x / 10;
        }
        for (int i = 0; i <= (result.length() - 1) / 2; i++) {
            int j = result.length() - 1 - i;
            if (result.charAt(i) != result.charAt(j)) {
                return false;
            }
        }
        return true;

    }
}
