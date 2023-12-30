package com.leetcode.task_0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        // make Map
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {

            Integer value = wordsMap.get(word);
            if (value == null) {
                wordsMap.put(word, 1);
            } else {
                wordsMap.put(word, value + 1);
            }
        }

        // check all symbols
        int wordLength = words[0].length();
        for (int i = 0; i < s.length() - wordLength * words.length + 1; i++) {
            Map<String, Integer> map = new HashMap<>(wordsMap);
            int index = i;
            while (!map.isEmpty()) {
                if (s.length() < index + wordLength) {
                    break;
                }
                String word = s.substring(index, index + wordLength);
                Integer value = map.get(word);
                if (value == null) {
                    // map doesn't contain word, skip this position
                    break;
                }
                // word was found, let's decrement count and continue check
                if (value == 1) {
                    map.remove(word);
                } else {
                    map.put(word, value - 1);
                }
                index = index + wordLength;
            }
            if (map.isEmpty()) {
                result.add(i);
            }
        }
        return result;
    }

}
