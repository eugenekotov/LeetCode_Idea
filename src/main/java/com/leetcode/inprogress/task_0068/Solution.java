package com.leetcode.inprogress.task_0068;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static class Line {
        private List<String> words = new ArrayList<>();
        private int length = 0;

        public void addWord(String word) {
            words.add(word);
            if (words.size() > 1) {
                length++;
            }
            length = length + word.length();
        }

        public int length() {
            return length;
        }

        public int calcLength(String word) {
            return word.length() + (length > 0 ? 1 + length : 0);
        }

        public String getLine(int maxWidth) {
            // count new spaces
            int newSpaces = maxWidth - length();
            int newSpacesAfterEach = newSpaces;
            if (words.size() > 1) {
                newSpacesAfterEach = newSpaces / (words.size() - 1);
            }
            int restSpaces = newSpaces - newSpacesAfterEach * (words.size() - 1);
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < words.size() - 1; i ++) {
                stringBuilder.append(words.get(i)).append(spaces(newSpacesAfterEach + 1));
                if (restSpaces > 0) {
                    stringBuilder.append(" ");
                    restSpaces--;
                }
            }
            stringBuilder.append(words.get(words.size() - 1));
            if (stringBuilder.length() < maxWidth) {
                stringBuilder.append(spaces(maxWidth - stringBuilder.length()));
            }
            return stringBuilder.toString();
        }

        public String getLastLine(int maxWidth) {
            StringBuilder stringBuilder = new StringBuilder(words.get(0));
            for (int i = 1; i < words.size(); i++) {
                stringBuilder.append(" ").append(words.get(i));
            }
            if (stringBuilder.length() < maxWidth) {
                stringBuilder.append(spaces(maxWidth - stringBuilder.length()));
            }
            return stringBuilder.toString();
        }
    }

    private static String spaces(int n) {
        char[] charArray = new char[n];
        Arrays.fill(charArray, ' ');
        return new String(charArray);
//        return " ".repeat(n);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<Line> lines = new ArrayList<>();
        Line currentLine = new Line();
        for (int i = 0; i < words.length; i++) {
            int newLength = currentLine.calcLength(words[i]);
            if (newLength <= maxWidth) {
                currentLine.addWord(words[i]);
            } else {
                lines.add(currentLine);
                currentLine = new Line();
                currentLine.addWord(words[i]);
            }
        }
        if (currentLine.length() > 0) {
            lines.add(currentLine);
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < lines.size() - 1; i++) {
            result.add(lines.get(i).getLine(maxWidth));
        }
        result.add(lines.get(lines.size() - 1).getLastLine(maxWidth));
        return result;
    }

}
