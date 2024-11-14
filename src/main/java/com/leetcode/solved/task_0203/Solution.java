package com.leetcode.solved.task_0203;

import com.leetcode.ListNode;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        work(head, head.next, val);
        return head;
    }

    private void work(ListNode prior, ListNode current, int val) {
        if (current == null) {
            prior.next = null;
            return;
        } else {
            if (current.val != val) {
                prior.next = current;
                prior = current;
            }
            work(prior, current.next, val);
        }
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode result = null;
        ListNode prior = null;
        while (head != null) {
            if (head.val != val) {
                if (result == null) {
                    result = head;
                }
                prior = head;
                head = head.next;
            } else {
                head = head.next;
                if (prior != null) {
                    prior.next = head;
                }
            }
        }
        return result;
    }

}
