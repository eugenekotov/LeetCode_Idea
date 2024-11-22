package com.leetcode.inprogress.task_0143;

import com.leetcode.ListNode;

import java.util.Stack;

public class Solution {


    public void reorderList(ListNode head) {
        int count = 0;
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            count++;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            fast = fast.next;
        }
        // Revert second half
        ListNode newList = slow.next;
        ListNode oldList = newList.next;
        newList.next = null;
        slow.next = null;
        while (oldList != null) {
            count++;
            ListNode temp = oldList.next;
            oldList.next = newList;
            newList = oldList;
            oldList = temp;
        }
        // merge two lists
        while (head.next != null) {
            count++;
            ListNode temp = head.next;
            head.next = newList;
            newList = newList.next;
            head = head.next;
            head.next = temp;
            head = head.next;
        }
        if (newList != null) {
            head.next = newList;
        }
        System.out.println("2 iteration  count = " + count);
    }

    public void reorderList1(ListNode head) {
        int count = 0;
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        while (stack.peek().next != null) {
            count++;
            stack.push(stack.peek().next);
        }
        while (head.next != stack.peek() && head != stack.peek()) {
            count++;
            ListNode temp = head.next;
            head.next = stack.pop();
            head.next.next = temp;
            head = temp;
        }
        if (head.next == stack.peek()) {
            head.next.next = null;
        } else {
            head.next = null;
        }
        System.out.println("1 iteration  count = " + count);
    }
}
