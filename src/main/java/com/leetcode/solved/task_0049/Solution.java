package com.leetcode.solved.task_0049;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        for (String string : strs) {
            boolean added = false;
            for (int i = 0; i < result.size(); i++) {
                List<String> list = result.get(i);
                if (isAnagrams(list.get(0), string)) {
                    list.add(string);
                    added = true;
                    break;
                }
            }
            if (!added) {
                List<String> list = new ArrayList<>();
                list.add(string);
                result.add(list);
            }
        }
        return result;
    }

    private boolean isAnagrams(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        List<Character> array1 = toList(string1.toCharArray());
        for (char c : string2.toCharArray()) {
            Character symbol = c;
            if (!array1.remove(symbol)) {
                return false;
            }
        }
        return true;
    }

    private List<Character> toList(char[] array) {
        List<Character> result = new ArrayList<>(array.length);
        for (char c : array) {
            result.add(c);
        }
        return result;
    }
}
