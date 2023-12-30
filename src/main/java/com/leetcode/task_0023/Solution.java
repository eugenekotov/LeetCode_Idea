package com.leetcode.task_0023;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode node = null;
        boolean shouldContinue;
        do {
            int minValue = 0;
            List<Integer> minIndexes = new ArrayList<>();
            shouldContinue = false;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (minIndexes.isEmpty()) {
                        minValue = lists[i].val;
                        minIndexes.add(i);
                    } else {
                        if (lists[i].val == minValue) {
                            minIndexes.add(i);
                        } else {
                            shouldContinue = true;
                            if (lists[i].val < minValue) {
                                minValue = lists[i].val;
                                minIndexes.clear();
                                minIndexes.add(i);
                            }
                        }
                    }
                }
            }
            if (minIndexes.isEmpty()) {
                return result;
            }
            for (Integer minIndex : minIndexes) {
                lists[minIndex] = lists[minIndex].next;
                shouldContinue = shouldContinue || (lists[minIndex] != null);
                if (result == null) {
                    result = new ListNode(minValue);
                    node = result;
                } else {
                    node.next = new ListNode(minValue);
                    node = node.next;
                }
            }
        } while (shouldContinue);
        return result;
    }
 
}
