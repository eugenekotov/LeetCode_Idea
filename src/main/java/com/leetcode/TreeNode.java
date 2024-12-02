package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static String treeToString(TreeNode node) {
        if (node == null) {
            return "";
        }
        List<List<String>> levels = new ArrayList<>();
        treeNodeToString(node, levels, 0);

        StringBuilder result = new StringBuilder();
        int itemLength = 3;
        int indentLength = 1;
        int maxItemCount = (int) Math.pow(2, levels.size() - 1);
        int maxLength = getLength(maxItemCount, itemLength, indentLength);
        for (int i = 0; i < levels.size(); i++) {
            List<String> line = levels.get(i);
            int itemCount = (int) Math.pow(2, i);
            int indent = (maxLength - getLength(itemCount, itemLength, indentLength)) / 2;
            StringBuilder sb = new StringBuilder(" ".repeat(indent));
            addLine(line, sb, itemLength);
            result.append(sb.toString().stripTrailing()).append("\n");
        }
        return result.toString();
    }

    private static int getLength(int itemsCount, int itemLength, int indentLength) {
        return itemsCount * itemLength + (itemsCount - 1) * indentLength;
    }

    private static void addLine(List<String> line, StringBuilder sb, int itemLength) {
        for (int i = 0; i < line.size() - 1; i++) {
            sb.append(getItem(line.get(i), itemLength)).append(" ");
        }
        sb.append(getItem(line.get(line.size() - 1), itemLength));
    }

    private static String getItem(String item, int itemLength) {
        double d = ((double) (itemLength - item.length())) / 2;
        int before = (int) Math.ceil(d);
        int after = (int) Math.floor(d);
        if (before > 0 || after > 0) {
            item = ".".repeat(before) + item + ".".repeat(after);
        }
        return item;
    }

    private static void treeNodeToString(TreeNode node, List<List<String>> levels, int level) {
        List<String> list;
        if (levels.size() > level) {
            list = levels.get(level);
        } else {
            list = new ArrayList<>();
            levels.add(list);
        }
        if (node == null) {
            list.add("");
            return;
        }
        list.add(String.valueOf(node.val));
        if (node.left != null || node.right != null) {
            treeNodeToString(node.left, levels, level + 1);
            treeNodeToString(node.right, levels, level + 1);
        }
    }

}
