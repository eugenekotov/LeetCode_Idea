package com.leetcode.solved.task_0039;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // remove candidates lager than target
        List<Integer> candidatesList = new ArrayList<>();
        for (int c : candidates) {
            if (c <= target) {
                candidatesList.add(c);
            }
        }
        // Sort
        candidatesList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        Map<Integer, List<List<Integer>>> sums = new HashMap<>(); // key - sum, value - всі можливі шляхи сум
        List<List<Integer>> result = new ArrayList<>();
        Set<String> resultSet = new HashSet<>();

        int index = 0; // номер у кандидатах
        while (index < candidatesList.size()) {
            Integer candidate = candidatesList.get(index);
            int maxNum = target / candidate; // Максимальна кількість кандидатів
            // Перевіряємо суму однакових чисел кандидата
            if (target % candidate == 0) {
                List<Integer> resultItem = new ArrayList<>(Collections.nCopies(target / candidate, candidate));
                result.add(resultItem);
                maxNum = target / candidate - 1;
            }
            // Перевіряємо по черзі всі сумми з кандидатами
            boolean needsContinue = true; // false, якщо немає сенсу продовжувати з цим кандидатом
            for (int i = 1; i <= maxNum && needsContinue; i++) {
                needsContinue = false;
                int checkingValue = candidate * i;
                // Утворюємо нові суми і видаляємо ті, що більше target
                Set<Integer> keySet = new HashSet<>(sums.keySet());
                for(Integer key : keySet) {
                    if (key + candidate > target) {
                        // Точно видаляємо resultItems цього ключа
                        sums.remove(key);
                    } else {
                        if (key + checkingValue == target) {
                            // Влучили
                            needsContinue = true;
                            List<List<Integer>> resultItems = sums.get(key);
                            List<Integer> addon = new ArrayList<>(Collections.nCopies(i, candidate));
                            resultItems = resultItems.stream().map(resultItem -> new ArrayList<>(resultItem)).collect(Collectors.toList());
                            resultItems.forEach(resultItem -> resultItem.addAll(addon));
                            resultItems = resultItems.stream().filter(resultItem -> {
                                String str = getString(resultItem);
                                boolean res = !resultSet.contains(str);
                                resultSet.add(str);
                                return res;
                            }).collect(Collectors.toList());
                            result.addAll(resultItems);
                        } else if (key + checkingValue < target) {
                            // Додаємо нові варіанти
                            needsContinue = true;
                            List<List<Integer>> newVariantsItems = sums.get(key);
                            List<Integer> addon = new ArrayList<>(Collections.nCopies(i, candidate));
                            newVariantsItems = newVariantsItems.stream().map(newVariantItem -> new ArrayList<>(newVariantItem)).collect(Collectors.toList());
                            newVariantsItems.forEach(newVariantsItem -> newVariantsItem.addAll(addon));
                            Integer newKey = key + checkingValue;
                            List<List<Integer>> newKeyVariantsItems = sums.get(newKey);
                            if (newKeyVariantsItems == null) {
                                sums.put(newKey, newVariantsItems);
                            } else {
                                newKeyVariantsItems.addAll(newVariantsItems);
                            }
                        }
                    }
                }
            }
            // Додаємо суми виключно  кандидатів
            for (int i = 1; i <= maxNum; i++) {
                Integer key = candidate * i;
                List<Integer> variantItem = new ArrayList<>(Collections.nCopies(i, candidate));
                List<List<Integer>> variantItems = sums.get(key);
                if (variantItems == null) {
                    variantItems = new ArrayList<>();
                    sums.put(key, variantItems);
                }
                variantItems.add(variantItem);
            }
            index++;
        }
        return result;
    }

    private String getString(List<Integer> list) {
        StringBuilder result = new StringBuilder();
        list.forEach(item -> result.append(item));
        return result.toString();
    }
}
