package com.leetcode.solved.task_0010;

public class Solution {

    public boolean isMatch(String s, String p) {
        return isMatchIndex(s, 0, p, 0);
    }

    private boolean isMatchIndex(String s, int sIndex, String p, int pIndex) {
        while (sIndex != s.length() || pIndex != p.length()) {
            if (pIndex == p.length()) {
                return false;
            }
            char pChar = p.charAt(pIndex);
            if (isNextStar(p, pIndex)) {
                if (sIndex == s.length()) {
                    return isMatchIndex(s, sIndex, p, pIndex + 2);
                }
                if (pChar == '.') {
                    pIndex = pIndex + 2;
                    // Вариант 1. Нет символов из маски, просто двигаемся дальше по маске
                    if (isMatchIndex(s, sIndex, p, pIndex)) {
                        return true;
                    }
                    // Вариант 2. Есть символы из маски.
                    sIndex++;
                    while (sIndex != s.length()) {
                        if (isMatchIndex(s, sIndex, p, pIndex)) {
                            return true;
                        }
                        sIndex++;
                    }
                    return isMatchIndex(s, sIndex, p, pIndex);
                } else {
                    pIndex = pIndex + 2;
                    if (pChar == s.charAt(sIndex)) {
                        // есть символы из маски. обрезаем маску и пробуем все символы по очереди
                        while (sIndex != s.length() && pChar == s.charAt(sIndex)) {
                            if (isMatchIndex(s, sIndex, p, pIndex)) {
                                return true;
                            }
                            sIndex++;
                        }
                        return isMatchIndex(s, sIndex, p, pIndex);
                    } else {
                        // нет символов из маски, просто двигаемся дальше по маске
                        return isMatchIndex(s, sIndex, p, pIndex);
                    }
                }
            } else {
                // просто проверяем символ
                if (sIndex == s.length()) {
                    return false;
                }
                if (pChar == '.' || pChar == s.charAt(sIndex)) {
                    sIndex++;
                    pIndex++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isNextStar(String s, int index) {
        return index < s.length() - 1 && s.charAt(index + 1) == '*';
    }
}
