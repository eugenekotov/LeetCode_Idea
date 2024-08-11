package com.leetcode.solved.task_0039;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // remove candidates lager than target
        List<Integer> cList = new ArrayList<>();
        for (int c : candidates) {
            if (c <= target) {
                cList.add(c);
            }
        }
        // Sort
        cList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //
        return getCombinations(new ArrayList<>(), cList, target);
    }

    private List<List<Integer>> getCombinations(List<List<Integer>>begins, List<Integer> candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        while (index < candidates.size()) {
            // Calculate sum from elements from index
            int maxNum;
            if (target % candidates.get(index) == 0) {
                // Add default variant like 222 for 6
                List<Integer> resultItem = new ArrayList<>(Collections.nCopies(target / candidates.get(index), candidates.get(index)));
                result.add(resultItem);
                maxNum = target / candidates.get(index) - 1;
            } else {
                maxNum = target / candidates.get(index);
            }

            for (int i = maxNum; i >=0; i--) {

            }
        }

        return null;
    }


}
