package com.leetcode.solved.task_1642;

import java.util.*;

public class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights.length == 1) {
            return 0;
        }
        Queue<Integer> usedBreaks = new PriorityQueue<>(1000, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(02);
            }
        });
        int index = 0;
        while (index < heights.length) {
            if (index == heights.length - 1) {
                break;
            }
            if (heights[index] < heights[index + 1]) {
                int height = heights[index + 1] - heights[index];
                if (bricks >= height) {
                    // By default use bricks
                    usedBreaks.add(height);
                    bricks = bricks - height;
                } else if (ladders > 0) {
                    int maxBricks = 0;
                    if (usedBreaks.size() > 0) {
                        maxBricks = usedBreaks.peek();
                        // maxBricks = usedBreaks.get(usedBreaks.size() - 1);
                    }
                    if (height > maxBricks) {
                        ladders --;
                    } else {
                        while (bricks < height && ladders > 0 && usedBreaks.size() > 0) {
                            int usedBrick = usedBreaks.poll();
                            //int usedBrick = usedBreaks.remove(usedBreaks.size() - 1);
                            ladders--;
                            bricks = bricks + usedBrick;
                        }
                        if (bricks >= height) {
                            usedBreaks.add(height);
                            bricks = bricks - height;
                        } else {
                            // we can do nothing
                            break;
                        }
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

}
