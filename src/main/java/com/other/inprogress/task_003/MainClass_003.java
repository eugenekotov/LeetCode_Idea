package com.other.inprogress.task_003;

import com.leetcode.Utils;

public class MainClass_003 {

    // Binary search

    public static void main(String[] args) {
//        System.out.println("Index = " + getIndex(new int[]{1, 2, 3, 4}, 4));
//        System.out.println("Index = " + getIndex(new int[]{1, 2, 3, 4, 5}, 5));
//        System.out.println("Index = " + getIndex(new int[]{1, 2, 3, 4, 5}, 3));
//        System.out.println("Index = " + getIndex(new int[]{1, 2, 4, 5}, 3));
        System.out.println("small nearest index = " + getLowerNearestIndex(new int[]{1, 2, 4, 5}, 3));
    }

    private static int getIndex(int[] array, int value) {
        System.out.println("Looking for " + value + " in [" + Utils.arrayToString(array) + "]");
        int l = 0;
        int r = array.length - 1;
        System.out.println("l = "+ l +", r = " + r);
        while (l <= r) {
            int m = (r + l) / 2;
            if (array[m] == value) {
                return m;
            } else if (array[m] < value) {
                l = m + 1;
            } else {
                r = m - 1;
            }
            System.out.println("l = "+ l +", r = " + r);
        }

        System.out.println("Exit loop with l = "+ l +", r = " + r);
        return 0;
    }

    private static int getLowerNearestIndex(int[] array, int value) {
        System.out.println("Looking for " + value + " in [" + Utils.arrayToString(array) + "]");
        int l = 0;
        int r = array.length - 1;
        System.out.println("l = "+ l +", r = " + r);
        while (l <= r) {
            int m = (r + l) / 2;
            if (array[m] == value) {
                return m;
            } else if (array[m] < value) {
                l = m + 1;
            } else {
                r = m - 1;
            }
            System.out.println("l = "+ l +", r = " + r);
        }
        System.out.println("Exit loop with l = "+ l +", r = " + r);
        return 0;
    }

}
