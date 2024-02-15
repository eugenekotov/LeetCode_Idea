package com.leetcode.solved.task_1305;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();

        addNode(root1, result1);
        addNode(root2, result2);
        List<Integer> result = merge(result1, result2);
        return result;
    }

    private List<Integer> merge(List<Integer> result1, List<Integer> result2) {
        List<Integer> result = new ArrayList<>(result1.size() + result2.size());
        int index1 = 0;
        int index2 = 0;
        while (index1 < result1.size() && index2 < result2.size()) {
            Integer val1 = result1.get(index1);
            Integer val2 = result2.get(index2);
            if (val1 == val2) {
                result.add(val1);
                index1++;
                result.add(val2);
                index2++;
            } else if (val1 < val2) {
                result.add(val1);
                index1++;
            } else {
                result.add(val2);
                index2++;
            }
        }
        if (index1 < result1.size()) {
            result.addAll(result1.subList(index1, result1.size()));
        }
        if (index2 < result2.size()) {
            result.addAll(result2.subList(index2, result2.size()));
        }
        return result;
    }

    private void addNode(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        addNode(node.left, result);
        result.add(node.val);
        addNode(node.right, result);
    }
}
