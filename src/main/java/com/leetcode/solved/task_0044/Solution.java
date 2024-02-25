package com.leetcode.solved.task_0044;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean asterisk1 = p.charAt(0) == '*';
        boolean asterisk2 = p.charAt(p.length() - 1) == '*';
        String[] patterns = getPatterns(p);
        if (patterns.length == 0) {
            // We have only asterisks
            return true;
        }
        int sIndex = 0;
        for (int patternIndex = 0; patternIndex < patterns.length; patternIndex++) {
            String pattern = patterns[patternIndex];
            int index = getPatternIndex(s, sIndex, pattern, (patternIndex == 0 ? asterisk1 : true));
            if (index == -1) {
                return false;
            }
            sIndex = index + pattern.length();
        }
        if (sIndex != s.length() && !asterisk2) {
            // we can try to move last pattern to the end right
            if (asterisk1 || patterns.length > 1) {
                String lastPattern = patterns[patterns.length - 1];
                if (suitablePattern(s, s.length() - lastPattern.length(), lastPattern)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private int getPatternIndex(String s, int startIndex, String p, boolean fromAnyIndex) {
        if (!fromAnyIndex) {
            if (startIndex + p.length() > s.length()) {
                return -1;
            }
            return suitablePattern(s, startIndex, p) ? startIndex : -1;
        }
        int index = startIndex;
        while (index + p.length() <= s.length()) {
            if (suitablePattern(s, index, p)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private boolean suitablePattern(String s, int startIndex, String p) {
        for (int i = 0; i < p.length(); i++) {
            if (s.charAt(startIndex + i) != p.charAt(i) && p.charAt(i) != '?') {
                return false;
            }
        }
        return true;
    }

    private String[] getPatterns(String p) {
        if (p.isEmpty()) {
            return new String[0];
        }
        int indexAsterisk = p.indexOf('*');
        if (indexAsterisk == -1) {
            return new String[]{p};
        }
        int index = 0;
        List<String> result = new ArrayList<>();
        boolean asterisk = false;
        while (indexAsterisk != -1) {
            addPattern(result, p.substring(index, indexAsterisk));
            index = indexAsterisk + 1;
            indexAsterisk = p.indexOf('*', index);
        }
        if (index < p.length()) {
            addPattern(result, p.substring(index));
        }
        return result.toArray(new String[result.size()]);
    }

    private void addPattern(List<String> list, String pattern) {
        if (!pattern.isEmpty()) {
            list.add(pattern);
        }
    }
}
