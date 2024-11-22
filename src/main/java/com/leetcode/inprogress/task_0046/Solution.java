package com.leetcode.inprogress.task_0046;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        work(Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new)), list, result);
//        return result;
//    }
//
//    private void work(List<Integer> nums, List<Integer> list, List<List<Integer>> result) {
//        if (nums.isEmpty()) {
//            result.add(new ArrayList<>(list));
//        } else {
//            for (int i = 0; i < nums.size(); i++) {
//                Integer num = nums.remove(i);
//                list.add(num);
//                work(nums, list, result);
//                nums.add(i, num);
//                list.remove(list.size() - 1);
//            }
//        }
//    }

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
