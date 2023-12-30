package com.leetcode.task_0007;

public class Solution {
    public int reverse(int x) {
        int sign = Integer.signum(x);
        int result = 0;
        while (x != 0) {
            int oneDigit = x % 10;
            if ((sign > 0 && (Integer.MAX_VALUE - oneDigit) / 10 < result)
                    || (sign < 0 && (Integer.MIN_VALUE - oneDigit) / 10 > result)) {
                return 0;
            }
            result = result * 10 + oneDigit;
            x = x / 10;
        }
        return result;
    }
}
