package com.leetcode.task_0107;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        makeStep(root, 0);
        return result;
    }

    private void makeStep(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        List<Integer> levelList;
        if (level < result.size()) {
            levelList = result.get(result.size() - level - 1);
        } else {
            levelList = new ArrayList<>();
            result.add(0, levelList);
        }
        levelList.add(node.val);
        makeStep(node.left, level + 1);
        makeStep(node.right, level + 1);
    }
}
