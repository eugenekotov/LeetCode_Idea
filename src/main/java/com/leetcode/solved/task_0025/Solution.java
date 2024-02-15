package com.leetcode.solved.task_0025;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode node = head;
        while (node != null) {
            List<ListNode> nodes = new ArrayList<>();
            nodes.add(node);
            node = node.next;
            int i = 1;
            while (i < k && node != null) {
                nodes.add(node);
                node = node.next;
                i++;
            }
            if (i < k) {
                break;
            }
            switchNodes(nodes);
        }
        return head;
    }

    private void switchNodes(List<ListNode> nodes) {
        for (int i = 0; i < nodes.size() / 2; i++) {
            int val = nodes.get(i).val;
            nodes.get(i).val = nodes.get(nodes.size() - 1- i).val;
            nodes.get(nodes.size() - 1- i).val = val;
        }
    }
}
