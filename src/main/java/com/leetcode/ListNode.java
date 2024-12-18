package com.leetcode;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static ListNode getList(int[] array) {
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

    public static ListNode getListWithCycle(int[] array, int pos) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode rootNode = new ListNode(array[0]);
        ListNode cycleNode = null;
        if (pos == 0) {
            cycleNode = rootNode;
        }

        ListNode node = rootNode;
        for (int i = 1; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            if (pos == i) {
                cycleNode = newNode;
            }
            node.next = newNode;
            node = newNode;
        }
        if (cycleNode != null) {
            node.next = cycleNode;
        }
        return rootNode;
    }


    public static boolean equals(ListNode list1, ListNode list2) {
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

    public static String listToString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        if (node != null) {
            sb.append(node.val);
            while (node.next != null) {
                node = node.next;
                sb.append(", ").append(node.val);
            }
        }
        return sb.toString();
    }

}
