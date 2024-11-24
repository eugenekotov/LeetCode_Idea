package com.leetcode.solved.task_0086;

import com.leetcode.ListNode;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode first = null;
        ListNode firstHead = null;
        ListNode second = null;
        ListNode secondHead = null;
        while (head != null) {
            if (head.val < x) {
                if (first == null) {
                    first = head;
                    firstHead = head;
                } else {
                    first.next = head;
                    first = first.next;
                }
                head = head.next;
                first.next = null;
            } else {
                if (second == null) {
                    second = head;
                    secondHead = head;
                } else {
                    second.next = head;
                    second = second.next;
                }
                head = head.next;
                second.next = null;
            }
        }
        if (firstHead == null) {
            return secondHead;
        } else {
            first.next = secondHead;
        }
        return firstHead;
    }
}
