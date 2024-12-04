package com.leetcode.solved.task_0108;

import com.leetcode.TreeNode;
import com.leetcode.Utils;

public class MainClass_0108 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        int[] array = new int[]{-10, -3, 0, 5, 9};
        System.out.println(Utils.arrayToString(array) + " -> ");
        TreeNode treeNode = solution.sortedArrayToBST(array);
        System.out.println(TreeNode.treeToString(treeNode));
    }

}
