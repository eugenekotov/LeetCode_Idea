package com.leetcode.solved.task_0135;

public class Solution {

    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int[] candyArray = new int[ratings.length];
        candyArray[0] = 1;
        int result = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] > ratings[i]) {
                candyArray[i] = 1;
                result = result + candyArray[i];
                if (candyArray[i - 1] == 1) {
                    // повышаем предыдущие
                    for (int j = i - 1; j >= 0; j--) {
                        candyArray[j] = candyArray[j] + 1;
                        result++;
                        if (j == 0) {
                            break;
                        }
                        if (ratings[j - 1] <= ratings[j]) {
                            break;
                        } else if (candyArray[j - 1] > candyArray[j]) {
                            break;
                        }
                    }
                }
            } else if (ratings[i - 1] < ratings[i]) {
                candyArray[i] = candyArray[i - 1] + 1;
                result = result + candyArray[i];
            } else {
                candyArray[i] = 1;
                result = result + candyArray[i];
            }
        }
        return result;
    }
}
