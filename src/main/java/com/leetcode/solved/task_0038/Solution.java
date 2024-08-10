package com.leetcode.solved.task_0038;

public class Solution {

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = rle(result);
        }
        return result;
    }

    private String rle(String input) {
        if (input.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int counter = 1;
        String symbol = String.valueOf(input.charAt(0));
        int index = 1;
        while (index < input.length()) {
            String newSymbol = String.valueOf(input.charAt(index));
            if (newSymbol.equals(symbol)) {
                counter++;
            } else {
                result.append(counter).append(symbol);
                symbol = newSymbol;
                counter = 1;
            }
            index ++;
        }
        result.append(counter).append(symbol);
        return result.toString();
    }

}
