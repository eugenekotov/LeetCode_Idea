package com.leetcode.solved.task_1306;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    /**
     * BFS Поиск в ширину
     */
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        List<Integer> indexes = new ArrayList<>();
        indexes.add(start);
        while (!indexes.isEmpty()) {
            int index = indexes.remove(0);
            if (0 <= index && index < arr.length && !visited[index]) {
                if (arr[index] == 0) {
                    return true;
                }
                visited[index] = true;
                indexes.add(index - arr[index]);
                indexes.add(index + arr[index]);
            }
        }
        return false;
    }
}
