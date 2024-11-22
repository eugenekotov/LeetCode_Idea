package com.leetcode.inprogress.task_0046;

import com.leetcode.Utils;

public class MainClass_0046 {

    public static final Solution solution = new Solution();

    public static void main(String[] args) {

//        int[] nums = {1,2,3};
//        int[] nums = {0,1};
//        int[] nums = {1};
        int[] nums = {1,2,3,4,5};
        System.out.println(Utils.arrayToString(nums, ", ") + " >>> " + Utils.listToString(solution.permute(nums), ","));



    }

}
