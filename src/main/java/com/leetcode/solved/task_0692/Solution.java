package com.leetcode.solved.task_0692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private List<String> result;
    private Map<String, Integer> counter;
    private Map<String, Integer> places;

    public List<String> topKFrequent(String[] words, int k) {

        counter = new HashMap<>(); // Слово и количество вхождений
        places = new HashMap<>(); // Слово и на каком месте по рейтингу оно стоит
        result = new ArrayList<>(); // Слова упорядоченные по рейтингу

        for (String word : words) {
            int count = counter.getOrDefault(word, 0);
            count++;
            counter.put(word, count);
            addToResult(word, count);
        }
        return result;
    }

    private void addToResult(String word, int count) {
        Integer place = places.get(word);
        if (place == null) {
            addToEnd(word, count);
        } else {
            moveTop(word, count, place);
        }
    }

    private void moveTop(String word, int count, int oldPlace) {
        result.remove(oldPlace);
        addToEnd(word, count);
    }

    private void addToEnd(String word, int count) {
        int index = result.size() - 1;
        while (index >= 0 && (counter.get(result.get(index)) < count
                || (counter.get(result.get(index)) == count && result.get(index).compareTo(word) > 0))) {
            index--;
        }
        if (index == -1) {
            result.add(0, word);
            places.put(word, 0);
        } else {
            result.add(index + 1, word);
            places.put(word, index + 1);
        }
    }

}
