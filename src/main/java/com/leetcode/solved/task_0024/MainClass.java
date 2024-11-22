package com.leetcode.solved.task_0024;

import com.leetcode.ListNode;

public class MainClass {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode node = ListNode.getList(new int[]{1, 2, 3, 4});
        System.out.println(solution.swapPairs(node));

        node = ListNode.getList(new int[]{1, 2, 3});
        System.out.println(solution.swapPairs(node));
    }
}
