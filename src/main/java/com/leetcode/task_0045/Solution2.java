package com.leetcode.task_0045;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        if (nums.length == 2) {
            // In cell with index 1 we can jump using only one way
            return 1;
        }
        // Array contains minimum jumps to cells. It starts from second cell of "nums".
        // For nums[1] minimum is in mins[0].
        int[] mins = new int[nums.length];
        // Fill array by start values
        mins[0] = 0;
        mins[1] = 1;
        // Cell indexes from which we can jump to current cell
        List<Integer> indexes = new ArrayList<>();
        if (nums[0] > 1) {
            indexes.add(0);
        }
        if (nums[1] > 0) {
            indexes.add(1);
        }

        for (int i = 2; i < nums.length; i ++) {
            int minValue = getMin(mins, nums, indexes, i) + 1;
            mins[i] = minValue;
            if (nums[i] > 0) {
                indexes.add(i);
            }
        }
        return mins[mins.length - 1];
    }

    private int getMin(int[] mins, int[] nums, List<Integer> indexes, int mainIndex) {
        int result = -1;
        // Iterate all indexes and find min value;
        int i = 0;
        while (i < indexes.size()) {
            // Check if index is correct
            int index = indexes.get(i);
            int value = nums[index];
            if (index + value < mainIndex) {
                // We can't jump from index. Remove index.
                indexes.remove(i);
                continue;
            }
            // Index is correct
            // Check for min value
            if (result == -1) {
                // First value
                result = mins[index];
            } else if (mins[index] < result) {
                result = mins[index];
            }
            i++;
        }
        return result;
    }

}
