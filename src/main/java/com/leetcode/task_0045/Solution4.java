package com.leetcode.task_0045;

import java.util.Arrays;

public class Solution4 {

    public int jump(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        int mainIndex = 0;
        int[] mins = new int[nums.length];
        Arrays.fill(mins, 0);

        while (mainIndex < nums.length - 1) {

            // ���� ������ ������������� ������
            // ���� mins[mainIndex] == 0, �� � ��� ������ ���������� �������
            while (mainIndex < nums.length - 1 && mins[mainIndex] == 0 && mainIndex > 0) {
                mainIndex++;
            }

            if (mainIndex == nums.length - 1) {
                // ������ �� �������� ������������� �����
                break;
            }

            // ���� ����� ������� �� 
            int min = mins[mainIndex];
            // ����� ��� ��� �����?
            if (mins[mins.length - 1] > 0 && mins[mins.length - 1] <= min) {
                // ��� �����, ��������� � ���������� �������
                mainIndex++;
                continue;
            }
            

            // ������ ������ �� �����
            int index1 = mainIndex;
            int index2;
            do {
                // ������ ������ ������
                index2 = Math.min(nums[index1] + index1, nums.length - 1);
                if (index2 == index1) {
                    // �� �� ��������, ���������� �������
                    break;
                }
                min++;
                // ����� ��� ��� �����?
                if (mins[mins.length - 1] > 0 && mins[mins.length - 1] <= min) {
                    // ��� �����, ��������� �������
                    break;
                }

                // ���� �� ����� ���� � ����� �� ��� ������� ����������� �������, ���������� �������
                if (mins[index2] >0 && mins[index2] <= min) {
                    // ���������� �������
                    break;
                }

                // ��������� mins
                for (int i = index1 + 1; i <= index2; i++) {
                    if (mins[i] == 0 || mins[i] > min) {
                        mins[i] = min;
                    }
                }
                index1 = index2;
            } while (index1 < nums.length - 1);
            //
            mainIndex++;
        }
        return mins[mins.length - 1];
    }

}
