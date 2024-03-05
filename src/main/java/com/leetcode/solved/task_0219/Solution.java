package com.leetcode.solved.task_0219;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> exists = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            if (!exists.add(nums[j])) {
                return true;
            } else if (exists.size() >= k + 1) {
                exists.remove(nums[j - k]);
            }
        }
        return false;
    }
}
