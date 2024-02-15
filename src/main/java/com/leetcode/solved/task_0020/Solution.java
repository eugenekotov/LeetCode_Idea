package com.leetcode.solved.task_0020;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        int i = 0;
        Stack<Character> stack = new Stack<Character>();
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
            case '(':
            case '[':
            case '{':
                stack.push(c);
                break;
            case '}':
                if (stack.isEmpty() || '{' != stack.pop()) {
                    return false;
                }
                break;
            case ')':
                if (stack.isEmpty() || '(' != stack.pop()) {
                    return false;
                }
                break;
            case ']':
                if (stack.isEmpty() || '[' != stack.pop()) {
                    return false;
                }
                break;

            default:
                throw new RuntimeException("Unexpected char (" + c + ")!");
            }
            i++;
        }
        return stack.isEmpty();
    }
}
