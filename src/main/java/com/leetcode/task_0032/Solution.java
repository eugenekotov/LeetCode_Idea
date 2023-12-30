package com.leetcode.task_0032;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int longestValidParentheses(String s) {
        char[] ch = s.toCharArray();
        int[] zeros = new int[s.length()];
        List<Integer> stack = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == '(') {
                // (
                stack.add(i);
            } else {
                // )
                if (!stack.isEmpty()) {
                    int index = stack.remove(stack.size() - 1);
                    int length = i - index + 1;
                    // ищем нули и берем длинну
                    if (index > 0) {
                        length = length + zeros[index - 1];
                    }
                    zeros[i] = length;
                    if (maxLength < length) {
                        maxLength = length;
                    }
                }
            }
        }
        return maxLength;
    }
}
