package com.leetcode.task_0214;

public class Solution {

    /**
     * Fastest solution is in Discuss
     */
    public String shortestPalindrome(String s) {

        StringBuilder result = new StringBuilder();
        boolean find = false;
        for (int i = s.length() / 2; i >= 0; i--) {
            // Проверяем тип 1
            if (0 < i && i < s.length() - 1 && s.charAt(i - 1) == s.charAt(i + 1)) {
                // Нашли тип 1, пытаемся расширить до конца
                boolean correct = true;
                for (int x1 = i - 2 , x2 = i + 2; x1 >=0 && x2 < s.length(); x1--, x2++) {
                    if (s.charAt(x1) != s.charAt(x2)) {
                        correct = false;
                        break;
                    }
                }
                if (correct) {
                    for (int j = s.length() - 1; j > 2 * i; j--) {
                        result.append(s.charAt(j));
                    }
                    find = true;
                    break;
                }
            }
            // Проверяем тип 2
            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                // Нашли тип 2, пытаемся расширить до конца
                boolean correct = true;
                for (int x1 = i - 2 , x2 = i + 1; x1 >=0; x1--, x2++) {
                    if (s.charAt(x1) != s.charAt(x2)) {
                        correct = false;
                        break;
                    }
                }
                if (correct) {
                    for (int j = s.length() - 1; j > 2 * i - 1; j--) {
                        result.append(s.charAt(j));
                    }
                    find = true;
                    break;
                }
            }
        }

        if (!find) {
            for (int j = s.length() - 1; j > 0; j--) {
                result.append(s.charAt(j));
            }
        }
        result.append(s);
        return result.toString();
    }

}
