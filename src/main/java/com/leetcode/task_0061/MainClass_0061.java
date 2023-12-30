package com.leetcode.task_0061;

public class MainClass_0061 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        //ListNode node = generateList(new int[]{1, 2, 3, 4, 5});
        ListNode node = generateList(new int[]{1, 2});
        System.out.println(solution.rotateRight(node, 2));
    }

    private static ListNode generateList(int[] array) {
        ListNode firstNode = new ListNode(array[0]);
        ListNode node = firstNode;
        for (int i = 1; i < array.length; i++) {
            ListNode tempNode = new ListNode(array[i]);
            node.next = tempNode;
            node = tempNode;
        }
        return firstNode;
    }
}
