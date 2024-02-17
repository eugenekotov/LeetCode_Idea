package com.leetcode.inprogress.task_1642;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights.length == 1) {
            return 0;
        }
        List<Used> usedLadders = new ArrayList<>();
        List<Used> usedBricks = new ArrayList<>();
        int index = 0;
        while (index < heights.length) {
            if (index == heights.length - 1) {
                break;
            }
            if (heights[index] < heights[index + 1]) {
                int height = heights[index + 1] - heights[index];
                if (height == 1 && bricks > 0) {
                    // Use brick
                    addToUsed(usedBricks, new Used(index, height));
                    bricks--;
                } else if (ladders > 0) {
                    // By default use ladder
                    addToUsed(usedLadders, new Used(index, height));
                    ladders--;
                } else if (bricks > 0 && bricks >= height) {
                    // we can move
                    addToUsed(usedBricks, new Used(index, height));
                    bricks = bricks - height;
                } else if ((usedBricks.size() > 0 || bricks > 0) && usedLadders.size() > 0) {
                    // we have to change ladder and bricks if we used ladder for height bigger then we used bricks
                    while (usedBricks.size() > 0 && usedLadders.size() > 0 && usedBricks.get(usedBricks.size() - 1).height > usedLadders.get(0).height) {
                        // Change Brick to Ladder
                        Used usedBrick = usedBricks.remove(usedBricks.size() - 1);
                        Used usedLadder = usedLadders.remove(0);
                        addToUsed(usedBricks, new Used(usedLadder.index, usedLadder.height));
                        addToUsed(usedLadders, new Used(usedBrick.index, usedBrick.height));
                        bricks = bricks - usedLadder.height + usedBrick.height;
                    }
                    if (bricks >= height) {
                        // we can move again
                        addToUsed(usedBricks, new Used(index, height));
                        bricks = bricks - height;
                    } else if (bricks > 0 && usedLadders.size() > 0 && usedLadders.get(0).height <= bricks) {
                        // We can change Ladder to Bricks to current step
                        Used usedLadder = usedLadders.remove(0);
                        addToUsed(usedBricks, new Used(usedLadder.index, usedLadder.height));
                        bricks = bricks - usedLadder.height;
                        addToUsed(usedLadders, new Used(index, height));
                    } else {
                        // we can do nothing
                        break;
                    }
                } else {
                    // we can do nothing
                    break;
                }
            }
            index++;
        }
        return index;
    }

    private void addToUsed(List<Used> usedList, Used usedValue) {
        if (usedList.size() == 0) {
            usedList.add(usedValue);
            return;
        }
        if (usedList.size() == 1) {
            if (usedValue.height >= usedList.get(0).height) {
                usedList.add(usedValue);
            } else {
                usedList.add(0, usedValue);
            }
            return;
        }
        if (usedValue.height >= usedList.get(usedList.size() - 1).height) {
            usedList.add(usedValue);
            return;
        }
        int index1 = 0;
        int index2 = usedList.size() - 1;
        while ((index2 - index1) > 1) {
            int index = (index2 + index1) / 2;
            if (usedValue.height == usedList.get(index).height) {
                usedList.add(index, usedValue);
                return;
            } else if (usedValue.height > usedList.get(index).height) {
                index1 = index;
            } else index2 = index;
        }
        usedList.add(index2, usedValue);
    }

    private static class Used {
        int index;
        int height;

        public Used(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
