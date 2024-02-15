package com.leetcode.solved.task_0004;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arraySize = nums1.length + nums2.length;
        int lastIndex = arraySize / 2;
        int[] array = new int[arraySize];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < nums1.length || index2 < nums2.length) {
            if (index1 < nums1.length && index2 < nums2.length) {
                int num1 = nums1[index1];
                int num2 = nums2[index2];
                if (num1 == num2) {
                    // 1
                    array[index] = num1;
                    index1++;
                    index++;
                    // 2
                    array[index] = num2;
                    index2++;
                    index++;
                } else if (num1 < num2) {
                    // 1
                    array[index] = num1;
                    index1++;
                    index++;
                } else {
                    // 2
                    array[index] = num2;
                    index2++;
                    index++;
                }
                if (index > lastIndex) {
                    break;
                }
            } else if (index1 < nums1.length && index2 == nums2.length) {
                // only nums1
                while (index <= lastIndex) {
                    array[index] = nums1[index1];
                    index1++;
                    index++;
                }
                break;
            } else {
                // only nums2
                while (index <= lastIndex) {
                    array[index] = nums2[index2];
                    index2++;
                    index++;
                }
                break;
            }
        }

        double result;

        if (arraySize % 2 == 0) {
            result = ((double) (array[lastIndex - 1] + array[lastIndex])) / 2;
        } else {
            result = array[lastIndex];
        }

        return result;
    }
}
