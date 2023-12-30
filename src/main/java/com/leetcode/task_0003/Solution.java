package com.leetcode.task_0003;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int index1 = 0;
        int index2 = 1;
        int lagest = 0;
        while (index2 < chars.length) {
            char c = chars[index2];
            int index = -1;
            for (int i = index1; i < index2; i++) {
                if (chars[i] == c) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                index2++;
            } else {
                if (lagest < index2 - index1) {
                    lagest = index2 - index1;
                }
                index1 = index + 1;
            }
        }
        if (lagest < index2 - index1) {
            lagest = index2 - index1;
        }
        return lagest;
    }
}
