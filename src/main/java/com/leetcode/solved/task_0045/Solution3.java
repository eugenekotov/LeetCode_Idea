package com.leetcode.solved.task_0045;

import java.util.Arrays;

public class Solution3 {

    private int[] mins;

    public int jump(int[] nums) {
        int mainIndex = 0;
        int value = 0;
        mins = new int[nums.length];
        Arrays.fill(mins, 0);
        nextJump(nums, mainIndex, value, "");
        return mins[mins.length - 1];
    }

    private void nextJump(int[] nums, int index, int value, String indent) {
        // System.out.println(indent + "�������� ��������, ������ == " + index + ", �������� == " + value);
        int nextIndex = Math.min(nums[index] + index, nums.length - 1);
        if (nextIndex == index) {
            // �� �� ��������, ���������
            // // System.out.println(indent + "We found 0");
            return;
        }
        value++;
        if (mins[nextIndex] == 0) {
            // ��� ����� ������ ���
            mins[nextIndex] = value;
            // ���������� ����
        } else if (value < mins[nextIndex]) {
            // �� ����� ����, �� �� ������� ���-�� �����
            mins[nextIndex] = value;
            // ���������� ����
        } else {
            // �� ����� ����, �� �� ������� ���-�� �����
            // �������
            // System.out.println(indent + "�� ����� ��� ���� �� ������� ���������� �����!");
            return;
        }
        // ����� ��� � ��� ������� ������?
        if (mins[mins.length - 1] > 0 && mins[mins.length - 1] <= value) {
            // System.out.println(indent + "��� ������� ����� �����! �������");
            return;
        }
        // ������� ������, ���� �� ��������� �� ����� 
        if (nextIndex < nums.length - 1) {
            // ������� � ������ ������� �� nextIndex �� index ����
            // System.out.println(indent + "Check Indexes from " + (index + 1) + " to " + nextIndex);
            indent = indent + "  ";
            for (int i = nextIndex; i > index; i --) {
                // System.out.println(indent + "Start from Index == " + i);
                nextJump(nums, i, value, indent);
            }
        } else {
            // System.out.println(indent + "�� �������� ����� �������!");
        }
    }

}
