package com.leetcode.solved.task_1306;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    private Set<Integer> visited;

    public boolean canReach(int[] arr, int start) {
        visited = new HashSet<>();
        return jump(arr, start);
    }

    private boolean jump(int[] arr, int start) {
        if (start < 0 || start > arr.length - 1 || visited.contains(start)) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        visited.add(start);
        return jump(arr, start - arr[start]) || jump(arr, start + arr[start]); 
    }
}
