package com.leetcode.inprogress.task_1642;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights.length == 1) {
            return 0;
        }
        List<Used> usedLadders = new ArrayList<>();
        int index = 0;
        while (index < heights.length) {
            if (index == heights.length - 1) {
                break;
            }
            if (heights[index] < heights[index + 1]) {
                int height = heights[index + 1] - heights[index];
                if (height == 1 && bricks > 0) {
                    // Use brick
                    bricks--;
                } else if (ladders > 0) {
                    // By default use ladder
                    addToUsed(usedLadders, new Used(index, height));
                    ladders--;
                } else if (usedLadders.size() > 0 && height > usedLadders.get(0).height && bricks >= usedLadders.get(0).height) {
                    // We can change ladder to bricks
                    Used usedLadder = usedLadders.remove(0);
                    bricks = bricks - usedLadder.height;
                    addToUsed(usedLadders, new Used(index, height));
                } else if (bricks >= height) {
                    bricks = bricks - height;
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
