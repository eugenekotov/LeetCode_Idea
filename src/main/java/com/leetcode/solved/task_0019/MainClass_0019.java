package com.leetcode.solved.task_0019;

import com.leetcode.ListNode;

public class MainClass_0019 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode node = ListNode.getList(new int[]{1, 2, 3, 4, 5});
        String s1 = ListNode.listToString(node);
        String s2 = ListNode.listToString(solution.removeNthFromEnd(node, 5));
        System.out.println(s1 + " -> " + s2);
    }

}
