package com.leetcode.solved.task_0206;

import com.leetcode.ListNode;

public class MainClass_0206 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode head = ListNode.getList(new int[]{1, 2, 3, 4, 5});
        System.out.printf("%s -> %s", head.toString(), solution.reverseList(head).toString());
    }
}
