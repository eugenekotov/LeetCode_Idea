package com.leetcode.task_0076;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public String minWindow(String s, String t) {

        Map<String, Integer> letters = getLettersMap(t);
        Set<String> lettersSet = new HashSet<String>(letters.keySet());

        Map<String, Integer> reserve = new HashMap<>();

        // Looking for first correct letter
        int start = 0;
        while (start < s.length() && !lettersSet.contains(String.valueOf(s.charAt(start)))) {
            start++;
        }
        // Did we find?
        if (start == s.length()) {
            return ""; // Nope
        }

        // Remove first correct letter from Letters
        String letter = String.valueOf(s.charAt(start));
        Integer count = letters.get(letter);
        if (count == 1) {
            letters.remove(letter);
        } else {
            letters.put(letter, count - 1);
        }
        // Looking for finish
        int finish = start + 1;
        while (finish < s.length() && !letters.isEmpty()) {
            letter = String.valueOf(s.charAt(finish));
            if (lettersSet.contains(letter)) {
                count = letters.get(letter);
                if (count != null) {
                    if (count == 1) {
                        letters.remove(letter);
                    } else {
                        letters.put(letter, count - 1);
                    }
                } else {
                    // Add to Reserve
                    count = reserve.get(letter);
                    if (count == null) {
                        count = 0;
                    }
                    reserve.put(letter, count + 1);
                }
            }
            finish++;
        }
        if (!letters.isEmpty()) {
            // Substring is not found
            return "";
        }
        int minStart = start;
        finish--;
        int minFinish = finish;
        //
        while (finish < s.length()) {
            // save first letter
            letter = String.valueOf(s.charAt(start));
            // move start to next correct letter
            start++;
            while (start < s.length() && !lettersSet.contains(String.valueOf(s.charAt(start)))) {
                start++;
            }
            // now looking for saved letter in S and Reserve
            // looking in Reserve
            if (reserve.containsKey(letter)) {
                // Move from Reserve to Indexes
                count = reserve.get(letter);
                if (count == 1) {
                    reserve.remove(letter);
                } else {
                    reserve.put(letter, count - 1);
                }
                // We have completed substring
                if (minFinish - minStart > finish - start) {
                    minStart = start;
                    minFinish = finish;
                }
            } else {
                // no letter in Reserve, let's move finish
                finish++;
                while (finish < s.length() && !letter.equals(String.valueOf(s.charAt(finish)))) {
                    String currentLetter = String.valueOf(s.charAt(finish));
                    if (lettersSet.contains(currentLetter)) {
                        // Add to Reserve
                        count = reserve.get(currentLetter);
                        if (count == null) {
                            count = 0;
                        }
                        reserve.put(currentLetter, count + 1);
                    }
                    finish++;
                }
                // Did we find?
                if (finish == s.length()) {
                    break;
                }
                if (minFinish - minStart > finish - start) {
                    minStart = start;
                    minFinish = finish;
                }
            }
        }
        return s.substring(minStart, minFinish + 1);
    }

    private Map<String, Integer> getLettersMap(String string) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            String letter = String.valueOf(string.charAt(i));
            result.put(letter, result.getOrDefault(letter, 0) + 1);
        }
        return result;
    }
}
