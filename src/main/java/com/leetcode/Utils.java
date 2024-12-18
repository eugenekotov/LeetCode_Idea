package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Utils {

    private Utils() {
    }

    public static void printList(List<String> list) {
        list.forEach(line -> System.out.println(line));
    }

    public static void printListInLine(List<String> list) {
        printListInLine(list, ", ");
    }

    public static void printListInLine(List<String> list, String separator) {
        System.out.println(listToString(list, separator));
    }

    public static <T> String listToString(List<T> list, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            String item = object.toString();
            if (object instanceof List) {
                item = "[" + listToString((List<? extends Object>) object, separator) + "]";
            } else if (object instanceof int[]) {
                item = "[" + arrayToString((int[]) object) + "]";
            }
            sb.append(item);
            if (i < list.size() - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    public static <T> String arrayToString(T[] array) {
        return arrayToString(array, ", ");
    }

    public static <T> String arrayToString(T[] array, String separator) {
        return listToString(new ArrayList<>(Arrays.asList(array)), separator);
    }

    public static String arrayToString(int[] array) {
        return arrayToString(array, ", ");
    }

    public static String arrayToString(int[] array, String separator) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        return listToString(list, separator);
    }

    public static String intToBinary(int value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int bit = (int) Math.pow(2, i);
            int r = value & bit;
            if (r == 0) {
                result.insert(0, "0");
            } else {
                result.insert(0, "1");
            }
        }
        return result.toString();
    }

    public static int[] generateArray(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
