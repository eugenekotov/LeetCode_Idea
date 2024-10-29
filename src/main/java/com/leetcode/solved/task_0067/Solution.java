package com.leetcode.solved.task_0067;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int register = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int aInt = i < a.length() ? Character.getNumericValue(a.charAt(a.length() - i - 1)) : 0;
            int bInt = i < b.length() ? Character.getNumericValue(b.charAt(b.length() - i - 1)) : 0;
            int sum = aInt + bInt + register;
            if (sum < 2) {
                result.insert(0, String.valueOf(sum));
                register = 0;
            } else if (sum == 2) {
                result.insert(0, "0");
                register = 1;
            } else {
                result.insert(0, "1");
                register = 1;
            }
        }
        if (register > 0) {
            result.insert(0, "1");
        }
        return result.toString();
    }
}
