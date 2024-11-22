package com.leetcode.solved.task_0141;

import com.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while (head != null && head.next != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }

}
