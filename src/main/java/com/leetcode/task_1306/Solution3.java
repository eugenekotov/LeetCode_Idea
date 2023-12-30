package com.leetcode.task_1306;

public class Solution3 {

    private boolean[] visited;

    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        return jump(arr, start);
    }

    private boolean jump(int[] arr, int start) {
        if (start < 0 || start > arr.length - 1 || visited[start]) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        visited[start] = true;
        return jump(arr, start - arr[start]) || jump(arr, start + arr[start]); 
    }
}
