package com.leetcode.solved.task_0108;

import com.leetcode.TreeNode;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return work(nums, 0, nums.length - 1);
    }

    private TreeNode work(int[] nums, int i1, int i2) {
        if (i2 > i1) {
            int i = (i2 + i1) / 2;
            return new TreeNode(nums[i], work(nums, i1, i - 1), work(nums, i + 1, i2));
        } else if (i2 == i1) {
            return new TreeNode(nums[i1], null, null);
        }
        return null;
    }
}
