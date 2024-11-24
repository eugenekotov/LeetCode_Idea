package com.leetcode.solved.task_0086;

import com.leetcode.ListNode;

public class MainClass_0086 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode node = ListNode.getList(new int[]{1, 4, 3, 2, 5, 2});
        String s1 = ListNode.listToString(node);
        String s2 = ListNode.listToString(solution.partition(node, 3));
        System.out.println(s1 + " -> " + s2);
    }

}
