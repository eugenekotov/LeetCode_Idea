package com.other.inprogress.task_004;

import com.leetcode.Utils;

import java.util.Stack;

public class MainClass_004 {

    /** Stack
     * Задача від Google:
     * Є масив значень температури за різні дні. Потрібно знайти перший день після певного дня,
     * коли температура була вищою. Для кожного дня азписати значення у масив результату
     * int[] temp = { 12, 12, 13, 17, 16, 15, 21 }
     */

    public static void main(String[] args) {
        int[] temperatures = { 12, 12, 13, 17, 16, 15, 21 };
        System.out.println(Utils.arrayToString(getDays(temperatures)));
    }

    private static int[] getDays(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    result[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }
}
