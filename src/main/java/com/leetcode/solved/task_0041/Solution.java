package com.leetcode.solved.task_0041;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> hs = new HashSet<Integer>();

        for (int num : nums) {
            if (num > 0) {
                hs.add(num);
            }
        }

        for (int i = 1; i < hs.size() + 1; i++) {
            if (!hs.contains(i)) {
                return i;
            }
        }

        return hs.size() + 1;
    }
}
