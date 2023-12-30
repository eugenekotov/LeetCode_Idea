package com.leetcode.task_0045;

import java.util.Arrays;

public class Solution4 {

    public int jump(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }

        int mainIndex = 0;
        int[] mins = new int[nums.length];
        Arrays.fill(mins, 0);

        while (mainIndex < nums.length - 1) {

            // Ищем первую непроверенную ячейку
            // Если mins[mainIndex] == 0, то в эту ячейку невозможно попасть
            while (mainIndex < nums.length - 1 && mins[mainIndex] == 0 && mainIndex > 0) {
                mainIndex++;
            }

            if (mainIndex == nums.length - 1) {
                // Больше не осталось непроверенных ячеек
                break;
            }

            // Сюда можно попасть за 
            int min = mins[mainIndex];
            // Может это уже много?
            if (mins[mins.length - 1] > 0 && mins[mins.length - 1] <= min) {
                // Уже много, переходим к следующему индексу
                mainIndex++;
                continue;
            }
            

            // Делаем прыжки до конца
            int index1 = mainIndex;
            int index2;
            do {
                // Делаем первый прыжок
                index2 = Math.min(nums[index1] + index1, nums.length - 1);
                if (index2 == index1) {
                    // Мы не прыгнули, прекращаем прыгать
                    break;
                }
                min++;
                // Может это уже много?
                if (mins[mins.length - 1] > 0 && mins[mins.length - 1] <= min) {
                    // Уже много, прекращем прыгать
                    break;
                }

                // Если мы здесь были с таким же или меньшим количеством прыжков, прекращаем прыгать
                if (mins[index2] >0 && mins[index2] <= min) {
                    // Прекращаем прыгать
                    break;
                }

                // заполняем mins
                for (int i = index1 + 1; i <= index2; i++) {
                    if (mins[i] == 0 || mins[i] > min) {
                        mins[i] = min;
                    }
                }
                index1 = index2;
            } while (index1 < nums.length - 1);
            //
            mainIndex++;
        }
        return mins[mins.length - 1];
    }

}
