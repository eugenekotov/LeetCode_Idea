package com.leetcode.solved.task_0066;

public class Solution {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        boolean shouldIncrement = true;
        while (shouldIncrement && i >= 0) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                shouldIncrement = false;
            }
            i--;
        }
        if (shouldIncrement) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
        return digits;
    }

}
