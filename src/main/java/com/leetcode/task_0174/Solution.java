package com.leetcode.task_0174;

public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {

        int[][] mins = new int[dungeon.length][dungeon[0].length];

        for (int row = dungeon.length - 1; row >= 0; row--) {
            for (int col = dungeon[row].length - 1; col >= 0; col--) {
                boolean hasDown = hasDown(dungeon, row);
                boolean hasRight = hasRight(dungeon, col);
                int value = dungeon[row][col];
                if (!hasDown && !hasRight) {
                    if (value <= 0) {
                        value = Math.abs(value) + 1;
                    } else {
                        value = 1;
                    }
                    mins[row][col] = value;
                } else if (hasDown && hasRight) {
                    // both
                    int oldValueDown = mins[row + 1][col];
                    int newValueDown = getNewValue(value, oldValueDown);
                    int oldValueRight = mins[row][col + 1];
                    int newValueRight = getNewValue(value, oldValueRight);
                    if (newValueDown < newValueRight) {
                        mins[row][col] = newValueDown;
                    } else {
                        mins[row][col] = newValueRight;
                    }
                } else if (hasDown) {
                    // only down
                    int oldValueDown = mins[row + 1][col];
                    mins[row][col] = getNewValue(value, oldValueDown);
                } else {
                    // only right
                    int oldValueRight = mins[row][col + 1];
                    mins[row][col] = getNewValue(value, oldValueRight);
                }
            }
        }
        return mins[0][0];
    }

    private int getNewValue(int value, int oldValue) {
        if (value >= oldValue) {
            return 1;
        } else if (value >= 0) {
            return oldValue - value;
        } else {
            return Math.abs(value) + oldValue;
        }
    }

    private boolean hasDown(int[][] dungeon, int row) {
        return row < dungeon.length - 1;
    }

    private boolean hasRight(int[][] dungeon, int col) {
        return col < dungeon[0].length - 1;
    }

}
