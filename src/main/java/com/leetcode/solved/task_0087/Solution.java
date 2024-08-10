package com.leetcode.solved.task_0087;

import java.util.*;

public class Solution {

    private Map<String, Boolean> checked = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        checked = new HashMap<>();
        return isScramble2(s1, s2);
    }

    private boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() == 2) {
            String tempS = String.valueOf(s2.charAt(1)) + String.valueOf(s2.charAt(0));
            return s1.equals(tempS);
        }
        String key = s1 + s2;
        Boolean result = checked.get(key);
        if (result != null) {
            return result;
        }
        // Шукаємо як можна поділити щоб набір букв був той самий як у оригінальної сроки
        for (int i = 1; i < s1.length(); i++) {
            String s1_1 = s1.substring(0, i); // a
            String s1_2 = s1.substring(i); // bc
            {
                // Перевіряємо без зміни місць
                String s2_1 = s2.substring(0, i); // b
                String s2_2 = s2.substring(i); // ac
                if (checkSet(s1_1, s2_1) && checkSet(s1_2, s2_2)) {
                    if (isScramble2(s1_1, s2_1) && isScramble2(s1_2, s2_2)) {
                        checked.put(key, true);
                        return true;
                    }
                }
            }
            // Перевіряємо зі зміною місць
            {
                String s2_3 = s2.substring(0, s2.length() - i); // b
                String s2_4 = s2.substring(s2.length() - i); // ac
                if (checkSet(s1_1, s2_4) && checkSet(s1_2, s2_3)) {
                    if (isScramble2(s1_1, s2_4) && isScramble2(s1_2, s2_3)) {
                        checked.put(key, true);
                        return true;
                    }
                }
            }
        }
        checked.put(key, false);
        return false;
    }

    private boolean checkSet(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        Arrays.sort(array1);
        char[] array2 = s2.toCharArray();
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }

    private List<String> scramble(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() == 1) {
            result.add(s);
        } else if (s.length() == 2) {
            result.add(s);
            result.add(s.substring(1, 2) + s.substring(0, 1));
        } else {
            for (int i = 1; i < s.length(); i++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i);
                List<String> s1List = scramble(s1);
                List<String> s2List = scramble(s2);
                for (String s1String : s1List) {
                    for (String s2String : s2List) {
                        result.add(s1String + s2String);
                    }
                }
                for (String s1String : s1List) {
                    for (String s2String : s2List) {
                        result.add(s2String + s1String);
                    }
                }
            }
        }
        return result;
    }
}
