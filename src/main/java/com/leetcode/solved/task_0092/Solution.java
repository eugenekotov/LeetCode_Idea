package com.leetcode.solved.task_0092;

import com.leetcode.ListNode;

import java.util.Stack;

public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode currentNode = head;
        ListNode beforeLeft = null;
        while (i < left) {
            beforeLeft = currentNode;
            currentNode = currentNode.next;
            i++;
        }
        Stack<ListNode> reverted = new Stack<>();
        reverted.push(currentNode);
        while (i < right) {
            currentNode = currentNode.next;
            reverted.push(currentNode);
            i++;
        }
        ListNode afterRight = currentNode.next;
        while (!reverted.isEmpty()) {
            ListNode node = reverted.pop();
            if (beforeLeft == null) {
                beforeLeft = node;
                head = node;
            } else {
                beforeLeft.next = node;
                beforeLeft = beforeLeft.next;
            }
        }
        beforeLeft.next = afterRight;
        return head;
    }
}
