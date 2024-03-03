package com.leetcode.inprogress.task_0206;

import com.leetcode.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            result = new ListNode(head.val, result);
            head = head.next;
        }
        return result;
    }
}
