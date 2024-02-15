package com.leetcode.solved.task_0042;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int trap(int[] height) {
        List<Integer> peaks = getPeaks(height);
        if (peaks.size() < 2) {
            return 0;
        }
        removePits(height, peaks);
        //
        int result = 0;
        // –аботаем с парами пиков
        for (int j = 0; j < peaks.size() - 1; j++) {
            result = result + trap(height, peaks.get(j), peaks.get(j+1));
        }
        return result;
    }

    private void removePits(int[] height, List<Integer> peaks) {
        List<Integer> pits = getPits(height, peaks);
        while (!pits.isEmpty()) {
            for (int i = pits.size() - 1; i >= 0; i--) {
                peaks.remove((int) pits.get(i));
            }
            pits = getPits(height, peaks);
        }
    }

    private List<Integer> getPits(int[] height, List<Integer> peaks) {
        List<Integer> result = new ArrayList<>();
        int level = height[peaks.get(0)];
        boolean down = false;
        // ищем минимумы
        for (int i = 1; i < peaks.size(); i++) {
            if (down && level < height[peaks.get(i)]) {
                // предыдущий был минимум
                result.add(i - 1);
                down = false;
            } else if (level > height[peaks.get(i)]) {
                down = true;
            }
            level = height[peaks.get(i)];
        }
        return result;
    }

    
    
    
    
    
//    private void removePits(int[] height, List<Integer> peaks) {
//        List<Integer> pits = new ArrayList<>();
//        int level = height[peaks.get(0)];
//        // ищем тот, который ниже первого
//        int i = 1;
//        while (i < peaks.size() && level <= height[peaks.get(i)]) {
//            i ++;
//        }
//        boolean isUp = false;
//        int startDown = i;
//        
//        // ищем максимумы и минимумы
//        for (int i = 0; i < height.length; i++) {
//            if (isUp && level > height[i]) {
//                // предыдущий был максимум
//                pits.add(i - 1);
//                isUp = false;
//            } else if (level < height[i]) {
//                isUp = true;
//            }
//            level = height[i];
//        }
//        if (isUp) {
//            pits.add(height.length - 1);
//        }
//        return pits;
//
//    }

    private List<Integer> getPeaks(int[] height) {
        List<Integer> result = new ArrayList<>();
        int level = 0;
        boolean up = true;
        // ищем максимумы
        for (int i = 0; i < height.length; i++) {
            if (up && level > height[i]) {
                // предыдущий был максимум
                result.add(i - 1);
                up = false;
            } else if (level < height[i]) {
                up = true;
            }
            level = height[i];
        }
        if (up) {
            result.add(height.length - 1);
        }
        return result;
    }

    private int trap(int[] height, int i1, int i2) {
        int result = 0;
        int level = Math.min(height[i1], height[i2]);
        for (int i = i1 + 1; i < i2; i ++) {
            if (level > height[i]) {
                result = result + level - height[i];
            }
        }
        return result;
    }

}
