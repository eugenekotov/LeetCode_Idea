package com.leetcode.task_0002;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode node = null;
        int rest = 0;
        do {
            int res = rest;
            if (l1 != null) {
                res = res + l1.val;
            }
            if (l2 != null) {
                res = res + l2.val;
            }
            if (res > 9) {
                rest = 1;
                res = res % 10;
            } else {
                rest = 0;
            }
            if (node == null) {
                node = result;
                node.val = res;
            } else {
                node.next = new ListNode(res);
                node = node.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        } while (l1 != null || l2 != null);
        if (rest > 0) {
            if (node == null) {
                node = result;
                node.val = rest;
            } else {
                node.next = new ListNode(rest);
                node = node.next;
            }
        }
        return result;
    }

}
