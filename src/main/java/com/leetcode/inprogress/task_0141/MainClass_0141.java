package com.leetcode.inprogress.task_0141;

import com.leetcode.ListNode;

public class MainClass_0141 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {

//        ListNode node = ListNode.getList(new int[]{3, 2, 0, -4, 2});
        ListNode node = ListNode.getList(new int[]{1, 2});
        System.out.println(solution.hasCycle(node));
    }
}
