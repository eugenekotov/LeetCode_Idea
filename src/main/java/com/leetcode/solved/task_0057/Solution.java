package com.leetcode.solved.task_0057;

public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int count1 = getCount1(intervals, newInterval[0]);
        int i = count1;
        System.out.println(count1);
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        int[][] result = new int[count1 + intervals.length - i + 1][2];
        System.arraycopy(intervals, 0, result, 0, count1);
        result[count1] = newInterval;
        System.arraycopy(intervals, i, result, count1 + 1, intervals.length - i);

        return result;
    }

    private int getCount1(int[][] intervals, int value) {
        if (value < intervals[0][0]) {
            return 0;
        }
        if (intervals[intervals.length - 1][1] < value) {
            return intervals.length;
        }
        int x1 = 0;
        int x2 = intervals.length - 1;
        while (x2 - x1 > 1) {
            int x = (x2 + x1) / 2;
            if (intervals[x][1] < value) {
                x1 = x;
            } else if (value < intervals[x][0]) {
                x2 = x;
            } else {
                return x;
            }
        }
        if (intervals[x1][1] < value) {
            return x1 + 1;
        }
        return x1;
    }

//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        List<int[]> result = new ArrayList<>();
//        int i = 0;
//        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
//            result.add(intervals[i]);
//            i++;
//        }
//        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
//            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
//            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
//            i++;
//        }
//        result.add(newInterval);
//
//        while (i < intervals.length) {
//            result.add(intervals[i]);
//            i++;
//        }
//
//        return result.toArray(new int[result.size()][2]);
//    }

//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        List<int[]> result = new ArrayList<>();
//        boolean added = false;
//        int i = 0;
//        while (i < intervals.length) {
//            if (intervals[i][1] < newInterval[0] || newInterval[1] < intervals[i][0]) {
//                if (!added && newInterval[1] < intervals[i][0]) {
//                    result.add(newInterval);
//                    added = true;
//                }
//                result.add(intervals[i]);
//            } else {
//                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
//                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
//                if (!added) {
//                    result.add(newInterval);
//                    added = true;
//                }
//            }
//            i++;
//        }
//        if (!added) {
//            result.add(newInterval);
//        }
//
//        return result.toArray(new int[result.size()][2]);
//
//    }


}
