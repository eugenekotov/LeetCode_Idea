package com.leetcode.inprogress.task_0060;

import com.leetcode.Utils;

public class Solution {

    public String getPermutation(int n, int k) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        int arrayIndex = 0;


        System.out.println(Utils.arrayToString(array));
        return "";
    }

}
