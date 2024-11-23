package com.leetcode.solved.task_0142;

import com.leetcode.ListNode;

public class MainClass_0142 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode node = ListNode.getListWithCycle(new int[] {3,2,0,-4}, 1);
        System.out.println(solution.detectCycle(node));
    }

}
