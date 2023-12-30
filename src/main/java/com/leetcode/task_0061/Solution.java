package com.leetcode.task_0061;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        k = k % nodes.size();
        if (k == 0) {
            return nodes.get(0);
        }
        head = nodes.get(nodes.size() - k);
        nodes.get(nodes.size() - 1).next = nodes.get(0);
        nodes.get(nodes.size() - 1 - k).next = null;
        return head;
    }
}
