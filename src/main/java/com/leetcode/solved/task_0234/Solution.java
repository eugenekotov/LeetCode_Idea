package com.leetcode.solved.task_0234;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        List<Integer> result =  new ArrayList<>();
        result.add(head.val);
        while (head.next != null) {
            head = head.next;
            result.add(head.val);
        }
        for (int i = 0; i <= (result.size() - 1) / 2; i++) {
            int j = result.size() - 1 - i;
            if (!result.get(i).equals(result.get(j))) {
                return false;
            }
        }
        return true;
    }
}
