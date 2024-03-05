package com.leetcode.solved.task_0220;

import java.util.*;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> exists = new TreeSet<Integer>();
        for (int j = 0; j < nums.length; j++) {
            int value = nums[j];
            Integer checkValue = exists.floor(value);
            if (checkValue != null && Math.abs(checkValue - value) <= valueDiff) {
                return true;
            }
            checkValue = exists.ceiling(value);
            if (checkValue != null && Math.abs(checkValue - value) <= valueDiff) {
                return true;
            }
            exists.add(value);
            if (exists.size() >= indexDiff + 1) {
                exists.remove(nums[j - indexDiff]);
            }
        }
        return false;
    }
}
