package com.leetcode.solved.task_0084;

import java.util.*;

public class Solution {

    class Start {
        int index;
        int height;

        Start(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        List<Start> starts = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            if (i == 0 || heights[i - 1] < heights[i]) {
                if (heights[i] > 0) {
                    starts.add(new Start(i, heights[i]));
                }
            } else if (heights[i - 1] > heights[i]) {
                // we will do height smaller, let's check max area for current values
                Start previousStart = null;
                for (int j = starts.size() - 1; j >= 0; j--) {
                    Start start = starts.get(j);
                    int index = start.index;
                    int height = start.height;
                    if (height > heights[i]) {
                        int width = i - index;
                        int area = height * width;
                        if (result < area) {
                            result = area;
                        }
                        height = heights[i];
                        if (height == 0) {
                            starts.remove(start);
                        } else {
                            start.height = height;
                            if (previousStart != null) {
                                starts.remove(previousStart);
                            }
                            previousStart = start;
                        }
                    } else {
                        if (height >= previousStart.height) {
                            starts.remove(previousStart);
                        }
                        break;
                    }
                }
            }
        }

        for (int j = starts.size() - 1; j >= 0; j--) {
            Start start = starts.get(j);
            int index = start.index;
            int height = start.height;
            int width = heights.length - index;
            int area = height * width;
            if (result < area) {
                result = area;
            }
        }
        return result;
    }

}
