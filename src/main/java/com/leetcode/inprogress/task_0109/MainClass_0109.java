package com.leetcode.inprogress.task_0109;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

public class MainClass_0109 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode node = ListNode.getList(new int[]{-10, -3, 0, 5, 9});
        String s1 = ListNode.listToString(node);
        TreeNode treeNode = solution.sortedListToBST(node);
        System.out.println(s1 + " -> ");
        System.out.println(TreeNode.treeToString(treeNode));
    }

}
