package com.other.inprogress.task_002;

import java.util.Arrays;

public class MainClass_002 {

    public static void main(String[] args) {
        int[] parameters = {1, -2, 3, -1, 4,-5,6,-7};
        Integer[] result = new Integer[parameters.length];
        int counter = 0;
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i] < 0) {
                result[counter++] = parameters[i];
            } else {
                result[parameters.length - 1 - i + counter] = parameters[i];
            }
        }
        System.out.println(Arrays.deepToString(result));
    }
}
