package com.leetcode.task_0168;

public class Solution {

    public String convertToTitle(int n) {
        if (n > 0) {
            if (n <= 26) {
                return "" + (char) (n + 64);
            } else {
                int rest = n % 26;
                if (rest == 0) {
                    rest = 26;
                    n = n - 1;
                }
                return convertToTitle(n / 26) + (char) (rest + 64);
            }
        }
        return "";
    }
}
