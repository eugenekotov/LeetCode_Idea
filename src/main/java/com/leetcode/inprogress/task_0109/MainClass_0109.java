package com.leetcode.inprogress.task_0109;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

public class MainClass_0109 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode node = ListNode.getList(new int[]{1, 2, 3, 4, 5,6,7,8,9,10});
        String s1 = ListNode.listToString(node);
        TreeNode treeNode = solution.sortedListToBST(node);
        System.out.println(s1 + " -> ");
        System.out.println(TreeNode.treeToString(treeNode));
    }

}
