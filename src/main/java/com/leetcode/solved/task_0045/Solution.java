package com.leetcode.solved.task_0045;

public class Solution {

    public int jump(int[] nums) {
        int jump = 0; // ������� ���������� �������
        int reach = 0; // ������������ ������� ���������� �� �������
        int boundary = 0; // �������, ...
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
