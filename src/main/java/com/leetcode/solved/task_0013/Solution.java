package com.leetcode.solved.task_0013;

public class Solution {
    public int romanToInt(String s) {
        int previous = 0;
        int result = 0;

        char[] arr = s.toCharArray();

        int buffer = 0;
        for (int i = arr.length - 1; i >= 0; i--) {

            switch (s.charAt(i)) {
            case 'I':
                buffer = 1;
                break;
            case 'V':
                buffer = 5;
                break;
            case 'X':
                buffer = 10;
                break;
            case 'L':
                buffer = 50;
                break;
            case 'C':
                buffer = 100;
                break;
            case 'D':
                buffer = 500;
                break;
            case 'M':
                buffer = 1000;
                break;
            }

            if (buffer >= previous) {
                result = result + buffer;
                previous = buffer;
            } else {
                result = result - buffer;
            }

        }

        return result;
    }
}
