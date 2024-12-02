package com.other.inprogress.task_005;

import com.leetcode.Utils;

public class MainClass_005 {

    /**
     * Даний впорядкований масив та число К. Знайти два числа з масиву які в сумі дають К.
     */

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 7};

        System.out.println(Utils.arrayToString(getIndexes(array, 7)));
    }

    private static int[] getIndexes(int[] array, int k) {
        int x1 = 0;
        int x2 = array.length - 1;
        while (x1 < x2) {
            if (array[x1] + array[x2] < k) {
                x1++;
            } else if (array[x1] + array[x2] > k) {
                x2--;
            } else {
                return new int[] {x1, x2};
            }
        }
        return new int[]{};
    }
}
