package com.leetcode.solved.task_0045;

public class Solution {

    public int jump(int[] nums) {
        int jump = 0; // Текущее количество прыжков
        int reach = 0; // Максимальное текущее достижение по индексу
        int boundary = 0; // Граница, ...
        for (int i = 0; i < nums.length; i++) {
            if (i > boundary) {
                jump++;
                boundary = reach;
            }
            int nextIndex = nums[i] + i;
            reach = Math.max(reach, nextIndex);
        }
        return jump;
    }

}
