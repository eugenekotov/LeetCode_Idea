package com.leetcode.solved.task_0082;

import com.leetcode.ListNode;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode currentCorrect = null;
        while (head.next != null) {
            if (head.val == head.next.val) {
                // Ми маємо викинути head
                ListNode end = head.next.next;
                while (end != null) {
                    if (head.val != end.val) {
                        head = end;
                        break;
                    }
                    end = end.next;
                }
                if (end == null) {
                    return newHead;
                }
            } else {
                if (newHead == null) {
                    newHead = head;
                    currentCorrect = head;
                } else {
                    currentCorrect.next = head;
                    currentCorrect = currentCorrect.next;
                }
                head = head.next;
                currentCorrect.next = null;
            }
        }
        if (newHead == null) {
            newHead = head;
        } else {
            currentCorrect.next = head;
        }
        return newHead;
    }
}
