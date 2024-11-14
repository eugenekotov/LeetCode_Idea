package com.leetcode.solved.task_0203;

import com.leetcode.ListNode;

public class MainClass_0203 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        ListNode node = ListNode.getList(new int[]{6, 6, 6, 6, 1, 2, 6, 3, 4, 5, 6});
        System.out.println(solution.removeElements(node, 6));
    }
}
