package com.leetcode.solved.task_0019;

import com.leetcode.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 1;
        ListNode currentNode = head;
        while (i <= n) {
            currentNode = currentNode.next;
            i++;
        }
        if (currentNode == null) {
            return head.next;
        }
        ListNode nodeBeforeNth  = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            nodeBeforeNth = nodeBeforeNth.next;
        }
        nodeBeforeNth.next = nodeBeforeNth.next.next;
        return head;
    }
}
