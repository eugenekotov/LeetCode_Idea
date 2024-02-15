package com.leetcode.solved.task_0045;

import java.util.Arrays;

public class Solution3 {

    private int[] mins;

    public int jump(int[] nums) {
        int mainIndex = 0;
        int value = 0;
        mins = new int[nums.length];
        Arrays.fill(mins, 0);
        nextJump(nums, mainIndex, value, "");
        return mins[mins.length - 1];
    }

    private void nextJump(int[] nums, int index, int value, String indent) {
        // System.out.println(indent + "Начинаем процерку, индекс == " + index + ", значение == " + value);
        int nextIndex = Math.min(nums[index] + index, nums.length - 1);
        if (nextIndex == index) {
            // мы не прыгнули, завершаем
            // // System.out.println(indent + "We found 0");
            return;
        }
        value++;
        if (mins[nextIndex] == 0) {
            // Нас здесь небыло еще
            mins[nextIndex] = value;
            // продолжаем путь
        } else if (value < mins[nextIndex]) {
            // Мы здесь были, но за большее кол-во ходов
            mins[nextIndex] = value;
            // продолжаем путь
        } else {
            // Мы здесь были, но за меньшее кол-во ходов
            // выходим
            // System.out.println(indent + "Мы здесь уже были за меньшее количество ходов!");
            return;
        }
        // Может уже и так слишком доолго?
        if (mins[mins.length - 1] > 0 && mins[mins.length - 1] <= value) {
            // System.out.println(indent + "Уже слишком много ходов! выходим");
            return;
        }
        // прыгаем дальше, если не допрыгали до конца 
        if (nextIndex < nums.length - 1) {
            // прыгаем с кадого индекса от nextIndex до index вниз
            // System.out.println(indent + "Check Indexes from " + (index + 1) + " to " + nextIndex);
            indent = indent + "  ";
            for (int i = nextIndex; i > index; i --) {
                // System.out.println(indent + "Start from Index == " + i);
                nextJump(nums, i, value, indent);
            }
        } else {
            // System.out.println(indent + "Мы достигли конца массива!");
        }
    }

}
