package com.leetcode.solved.task_0024;

import com.leetcode.ListNode;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Switch head
        ListNode head2 = head.next;
        ListNode head3 = head2.next;
        head2.next = head;
        head.next = head3;
        head.next = swapPairs(head3);
        return head2;
    }
}
