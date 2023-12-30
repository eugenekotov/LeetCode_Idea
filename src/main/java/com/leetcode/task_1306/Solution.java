package com.leetcode.task_1306;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * BFS Поиск в ширину
     */
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> indexes = new LinkedList<>();
        indexes.offer(start);
        while (!indexes.isEmpty()) {
            int index = indexes.remove();
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
