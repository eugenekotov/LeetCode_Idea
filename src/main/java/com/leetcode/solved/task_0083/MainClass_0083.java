package com.leetcode.solved.task_0083;

import com.leetcode.ListNode;

public class MainClass_0083 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode node = ListNode.getList(new int[]{1, 1, 2, 3, 3});
        String s1 = ListNode.listToString(node);
        String s2 = ListNode.listToString(solution.deleteDuplicates(node));
        System.out.println(s1 + " -> " + s2);
    }

}
