package com.leetcode.inprogress.task_0109;

import com.leetcode.ListNode;
import com.leetcode.TreeNode;

public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        TreeNode left = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            left = new TreeNode(slow.val, left, null);
            slow = slow.next;
            fast = fast.next.next;
        }
        left = new TreeNode(slow.val, left, null);
        TreeNode right = null;
        slow = slow.next;
        while (slow != null) {
            right = new TreeNode(slow.val, right, null);
            slow = slow.next;
        }
        left.right = right;
        return left;
    }
}
