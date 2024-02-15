package com.leetcode.solved.task_0025;

public class MainClass_0025 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        checkSolution(getList(new int[] { 1, 2, 3, 4, 5 }), 1, getList(new int[] { 1, 2, 3, 4, 5 }));
        checkSolution(getList(new int[] { 1, 2, 3, 4, 5 }), 2, getList(new int[] { 2, 1, 4, 3, 5 }));
        checkSolution(getList(new int[] { 1, 2, 3, 4, 5 }), 3, getList(new int[] { 3, 2, 1, 4, 5 }));
        checkSolution(getList(new int[] { 1,2,3,4}), 4, getList(new int[] { 4, 3, 2, 1}));
    }

    private static void checkSolution(ListNode node, int k, ListNode expectedResult) {
        System.out.println(equals(solution.reverseKGroup(node, k), expectedResult));
    }

    private static ListNode getList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode rootNode = new ListNode(array[0]);
        ListNode node = rootNode;
        for (int i = 1; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            node.next = newNode;
            node = newNode;
        }
        return rootNode;
    }

    private static boolean equals(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return true;
        }
        if (list1 == null || list2 == null) {
            return false;
        }
        if (list1.val != list2.val) {
            return false;
        }
        return equals(list1.next, list2.next);
    }

}
