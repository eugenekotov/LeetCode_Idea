package com.leetcode.solved.task_0022;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        work(result, n, 0, 0, new StringBuilder());
        return result;
    }

    private void work(List<String> result, int n, int done, int openedCount, StringBuilder currentLine) {
        if (done == n && openedCount == 0) {
            result.add(currentLine.toString());
        } else {
            if (done < n) {
                currentLine.append("(");
                work(result, n, done + 1, openedCount + 1, currentLine);
                currentLine.deleteCharAt(currentLine.length() - 1);
            }
            if (openedCount > 0) {
                currentLine.append(")");
                work(result, n, done, openedCount - 1, currentLine);
                currentLine.deleteCharAt(currentLine.length() - 1);
            }
        }
    }

}
