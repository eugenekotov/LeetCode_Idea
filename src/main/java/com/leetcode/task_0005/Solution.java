package com.leetcode.task_0005;

public class Solution {

    /**
     * Dynamic
     */

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int x1R = 0;
        int x2R = 0;
        // Проходим строку и заполняем
        for (int i = 1; i < s.length(); i++) {
            if (i <s.length() - 1 && s.charAt(i-1) == s.charAt(i+1)) {
                // Нашли типа 1
                int x1 = i - 1;
                int x2 =  i + 1;
                if (x2R - x1R + 1 < x2 - x1 + 1) {
                    x1R = x1;
                    x2R = x2;
                }
                // Пытаемся увеличить
                while (true) {
                    x1--;
                    x2++;
                    if (0 <= x1 && x2 < s.length() && s.charAt(x1) == s.charAt(x2)) {
                        if (x2R - x1R + 1 < x2 - x1 + 1) {
                            x1R = x1;
                            x2R = x2;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (s.charAt(i-1) == s.charAt(i)) {
                // Нашли типа 2
                int x1 = i - 1;
                int x2 =  i;
                if (x2R - x1R + 1 < x2 - x1 + 1) {
                    x1R = x1;
                    x2R = x2;
                }
                // Пытаемся увеличить
                while (true) {
                    x1--;
                    x2++;
                    if (0 <= x1 && x2 < s.length() && s.charAt(x1) == s.charAt(x2)) {
                        if (x2R - x1R + 1 < x2 - x1 + 1) {
                            x1R = x1;
                            x2R = x2;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return s.substring(x1R, x2R + 1);
    }

}
