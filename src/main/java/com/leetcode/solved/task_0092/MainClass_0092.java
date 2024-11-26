package com.leetcode.solved.task_0092;

import com.leetcode.ListNode;

public class MainClass_0092 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
//        ListNode node = ListNode.getList(new int[]{1, 2, 3, 4, 5});
//        String s1 = ListNode.listToString(node);
//        String s2 = ListNode.listToString(solution.reverseBetween(node, 2, 4));


        ListNode node = ListNode.getList(new int[]{5});
        String s1 = ListNode.listToString(node);
        String s2 = ListNode.listToString(solution.reverseBetween(node, 1, 1));



        System.out.println(s1 + " -> " + s2);
    }

}
