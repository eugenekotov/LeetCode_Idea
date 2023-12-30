package com.leetcode.task_0032;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int longestValidParentheses(String s) {
        char[] ch = s.toCharArray();
        int[] zeros = new int[s.length()];
        List<Integer> stack = new ArrayList<Integer>();
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
                    int lenght = i - index + 1;
                    // ищем нули и берем длинну
                    if (index > 0) {
                        lenght = lenght + zeros[index - 1];
                    }
                    zeros[i] = lenght;
                    if (maxLength < lenght) {
                        maxLength = lenght;
                    }
                }
            }
        }
        return maxLength;
    }
}
