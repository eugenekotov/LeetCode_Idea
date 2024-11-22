package com.leetcode.solved.task_0143;

import com.leetcode.ListNode;
import com.leetcode.Utils;

import java.time.Duration;
import java.time.LocalTime;

public class MainClass_0143 {

    private static final Solution solution = new Solution();

    public static void main(String[] args) {

//        int[] array = Utils.generateArray(4);
//        ListNode node = ListNode.getList(array);
//        solution.reorderList(node);
//
//        array = Utils.generateArray(5);
//        node = ListNode.getList(array);
//        solution.reorderList(node);
//
//        array = Utils.generateArray(15);
//        node = ListNode.getList(array);
//        solution.reorderList(node);


        int[] array = Utils.generateArray(500000);
        ListNode node1 = ListNode.getList(array);
        ListNode node2 = ListNode.getList(array);
        LocalTime start1 = LocalTime.now();
        solution.reorderList1(node1);
        LocalTime finish1 = LocalTime.now();
        Duration duration1 = Duration.between(start1, finish1);
        System.out.println("First solution " + duration1.toMillis());
        LocalTime start2 = LocalTime.now();
        solution.reorderList(node2);
        LocalTime finish2 = LocalTime.now();
        Duration duration2 = Duration.between(start2, finish2);
        System.out.println("Second solution " + duration2.toMillis());
    }
}
