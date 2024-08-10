package com.leetcode.inprogress.task_0115;

import java.util.*;

public class Solution {

    public int numDistinct(String s, String t) {

        Map<Character, List<Integer>> lettersIndexesMap = new HashMap<>(); // key -letter, value - list of indexes where we have the letter;
        // looking for first indexes substring
        int posInS = 0;
        for (int letter = 0; letter < t.length(); letter++) {
            Character c = t.charAt(letter);
            if (lettersIndexesMap.containsKey(c)) {
                // We already found first index of letter c
                continue;
            }
            //noinspection DuplicateExpressions
            while (posInS < s.length() && s.charAt(posInS) != c && posInS <= s.length() - t.length() + letter) {
                // Ми шукаємо чергову літеру. Якщо по дорозі ми знійшли одну з попередніх літер, записуємо її індекс
                if (lettersIndexesMap.containsKey(s.charAt(posInS))) {
                    List<Integer> letterIndexes = lettersIndexesMap.get(s.charAt(posInS));
                    letterIndexes.add(posInS);
                }
                posInS++;
            }
            if (posInS < s.length() && s.charAt(posInS) == c) {
                // We found letter
                List<Integer> letterIndexes = new ArrayList<>();
                letterIndexes.add(posInS);
                lettersIndexesMap.put(c, letterIndexes);
                posInS++;
            } else {
                // We didn't find necessary letter
                return 0;
            }
        }
        // fill other indexes for all letters
        while (posInS < s.length()) {
            if (lettersIndexesMap.containsKey(s.charAt(posInS))) {
                List<Integer> letterIndexes = lettersIndexesMap.get(s.charAt(posInS));
                letterIndexes.add(posInS);
            }
            posInS++;
        }

        //
        int result = 0;
        int[] indexesInSArray = new int[t.length()]; // Поточні індекси строці t
        int[] indexesInLetterIndexes = new int[t.length()]; // Поточні індекси у відповідному лісті
        Set<Integer> indexesInTSet = new HashSet<>(); // теж саме але сет для перевірки унікальності
        // set start indexes
        // looking for first full substring
        for (int letter = 0; letter < t.length(); letter++) {
            Character c = t.charAt(letter);
            List<Integer> letterIndexes = lettersIndexesMap.get(c);
            int indexInLetterIndexes = 0;
            int indexInT = letterIndexes.get(indexInLetterIndexes);
            while (indexesInTSet.contains(indexInT) && indexInLetterIndexes < letterIndexes.size() - 1) {
                indexInLetterIndexes++;
                indexInT = letterIndexes.get(indexInLetterIndexes);
            }
            if (indexInLetterIndexes >= letterIndexes.size() - 1 && indexesInTSet.contains(indexInT)) {
                // Ми не маємо жодного варіанту
                return result;
            } else {
                indexesInSArray[letter] = indexInT;
                indexesInLetterIndexes[letter] = indexInLetterIndexes;
                indexesInTSet.add(indexInT);
            }
        }
        // Ми знайшли перше входження t
        result++;
        boolean found = false;
        do {
            found = false;
            indexesInTSet = new HashSet<>();
            // Намагаємось знайти підходящу позицію букви. Букви перебераємо з кінця.
            for (int letter = t.length() - 1; letter >= 0; letter--) {
                Character c = t.charAt(letter);
                List<Integer> letterIndexes = lettersIndexesMap.get(c);
                // Перевіряємо, чи є ще входження букви
                int indexesInLetterIndex = indexesInLetterIndexes[letter]; // current index in array
                if (indexesInLetterIndex < letterIndexes.size() - 1) {
                    indexesInLetterIndex++;
                    int indexInS = letterIndexes.get(indexesInLetterIndex);
                    while (indexesInLetterIndex < letterIndexes.size() && indexesInTSet.contains(indexInS) && indexInS < posInS) {
                        indexesInLetterIndex++;
                        indexInS = letterIndexes.get(indexesInLetterIndex);
                    }
                    // наступний індекс i
                    if (indexesInLetterIndex < letterIndexes.size() && !indexesInTSet.contains(indexInS) && (letter == t.length() - 1 || letterIndexes.get(indexesInLetterIndex) < posInS) ) {
                        // знайшли підходящу позицію
                        indexesInLetterIndexes[letter] = indexesInLetterIndex;
                        indexesInSArray[letter] = indexInS;
                        posInS = indexInS;
                        result++;
                        found = true;
                    }
                } else {
                    // Більше цієї букви ми не маємо
                    posInS = indexesInSArray[letter]; // index in string s
                }
                indexesInTSet.add(indexesInSArray[letter]);
            }
        } while (found);

        return result;
    }

}
