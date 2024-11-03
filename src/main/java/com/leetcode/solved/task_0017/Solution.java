package com.leetcode.solved.task_0017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private static final Map<String, String[]> map = new HashMap<String, String[]>();

    static {
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }

        findCombinations(0, combinations, digits, new StringBuilder());
        return combinations;

    }

    private void findCombinations(int index, List<String> result, String digits, StringBuilder currentThread) {
        if (index == digits.length()) {
            result.add(currentThread.toString());
        } else {
            String digit = String.valueOf(digits.charAt(index));
            String[] letters = map.get(digit);
            for (String letter: letters) {
                currentThread.append(letter);
                findCombinations(index + 1, result, digits, currentThread);
                currentThread.deleteCharAt(currentThread.length() - 1);
            }
        }
    }

//    public List<String> letterCombinations(String digits) {
//        List<String> result = new ArrayList<>();
//        if (digits.isEmpty()) {
//            return result;
//        }
//        for(String digit: digits.split("")) {
//            String[] digitArray = map.get(digit);
//            if (result.isEmpty()) {
//                List<String> finalResult = result;
//                Arrays.stream(digitArray).forEach(letter -> finalResult.add(letter));
//            } else {
//                List<String> newResult = new ArrayList<>();
//                List<String> finalResult = result;
//                Arrays.stream(digitArray).forEach(letter -> {
//                    newResult.addAll(finalResult.stream().map(res -> res + letter).collect(Collectors.toList()));
//                });
//                result = newResult;
//            }
//        }
//        return result;
//    }


}
