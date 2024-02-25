package com.leetcode.solved.task_0046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        List<List<Integer>> smallResult = permute(Arrays.copyOfRange(nums, 0, nums.length - 1));
        List<List<Integer>> result = new ArrayList<>(nums.length);
        for (int i = 0; i < smallResult.size(); i++) {
            // Take every line
            // Add new item for each place
            for (int j = 0; j < nums.length; j++) {
                List<Integer> list = new ArrayList<>(smallResult.get(i));
                list.add(j, nums[nums.length - 1]);
                result.add(list);
            }
        }
        return result;
    }
}
