package com.leetcode.task_0005;

public class Solution2 {

    /**
     * First variant
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        int x1 = 0;
        int size = 1;
        String result = s.substring(0, 1);
        while (x1 < s.length() - size) {
            int x2 = x1 + size + 1;
            while (x2 <= s.length()) {
                String subString = s.substring(x1, x2);
                if (isPalindrome(subString)) {
                    result = subString;
                    size = x2 - x1;
                }
                x2++;
            }
            x1++;
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
