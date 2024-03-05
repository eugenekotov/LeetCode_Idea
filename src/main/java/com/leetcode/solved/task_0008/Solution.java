package com.leetcode.solved.task_0008;

public class Solution {

    private static final String DIGITS = "0123456789";

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) != '+' && s.charAt(0) != '-' && !Character.isDigit(s.charAt(0))) {
            return 0;
        }
        int index1 = 0;
        boolean minus = false;
        if (!Character.isDigit(s.charAt(0))) {
            minus = s.charAt(0) == '-';
            index1++;
        }
        int index2 = index1;
        while (index2 < s.length() && Character.isDigit(s.charAt(index2))) {
            index2++;
        }
        if (index1 == index2) {
            return 0;
        }
        s = s.substring(index1, index2);
        long l = 0;
        for (int i = 0; i < s.length(); i++) {
            l = l * 10 + Integer.valueOf(String.valueOf(s.charAt(i)));
            if (l > Integer.MAX_VALUE) {
                break;
            }
        }
        if (minus) {
            l = -l;
            if (l < Integer.MIN_VALUE) {
                l = Integer.MIN_VALUE;
            }
        } else if (l > Integer.MAX_VALUE) {
            l = Integer.MAX_VALUE;
        }
        return (int) l;
    }
}
