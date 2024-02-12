package com.leetcode.task_0065;

public class Solution {

    private static String DIGITS = "0123456789";

    public boolean isNumber(String s) {
        s = s.toLowerCase();
        if (s.contains("e")) {
            int index = s.indexOf("e");
            String part1 = s.substring(0,index);
            String part2 = s.substring(index + 1);
            return checkPart(part1, true) && checkPart(part2, false);
        }
        return checkPart(s, true);
    }

    private boolean checkPart(String s, boolean dopIsPossible) {
        if (s.length() == 0) {
            return false;
        }
        int index = 0;
        boolean hasDigit = false;
        boolean hasDot = false;
        while (index < s.length()) {
            if ((s.charAt(index) == '+' || s.charAt(index) == '-')) {
                if (index > 0 || s.length() == 1) {
                    return false;
                }
            } else if (s.charAt(index) == '.') {
                if (dopIsPossible) {
                    if (hasDot) {
                        return false;
                    }
                } else {
                    return false;
                }
                hasDot = true;
            } else if (DIGITS.contains(String.valueOf(s.charAt(index)))) {
                hasDigit = true;
            } else {
                return false;
            }
            index++;
        }
        if (hasDot && !hasDigit) {
            return false;
        }
        return true;
    }
}
