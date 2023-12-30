package com.leetcode.task_0045;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainClass_0045 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
//        checkSolution(new int[] { 1, 2, 1, 2, 6, 9, 9, 0, 7, 2, 7, 2, 1, 4, 5, 0, 2, 5, 3, 0, 2, 7, 4, 7, 3, 6, 1, 9, 1,
//                4, 8, 4, 8, 9, 7, 4, 9 }, 8);
//        checkSolution(new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 }, 3);
//        checkSolution(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 8);
//        checkSolution(new int[] { 1, 1, 10, 1, 1, 1, 1, 1, 1 }, 3);
//        checkSolution(new int[] { 1, 2, 3, 4, 5 }, 3);
//        checkSolution(new int[] { 1, 9, 9, 9, 9, 9, 9, 9 }, 2);
//        checkSolution(new int[] { 1, 2, 3 }, 2);
//        checkSolution(new int[] { 0 }, 0);
//        checkSolution(new int[] { 1 }, 0);
        checkSolution(new int[] { 2, 3, 1, 1, 4 }, 2);
//        checkSolution(new int[] { 2, 3, 0, 1, 4 }, 2);
//        checkSolution(readFromFile("src\\com\\leetcode\\task_0045\\data_1.txt"), 2);
//        checkSolution(readFromFile("src\\com\\leetcode\\task_0045\\data_2.txt"), 24940);
//        checkSolution(new int[] { 5, 8, 1, 8, 9, 8, 7, 1, 7, 5, 8, 6, 5, 4, 7, 3, 9, 9, 0, 6, 6, 3, 4, 8, 0, 5, 8, 9, 5, 3, 7,
//                2, 1, 8, 2, 3, 8, 9, 4, 7, 6, 2, 5, 2, 8, 2, 7, 9, 3, 7, 6, 9, 2, 0, 8, 2, 7, 8, 4, 4, 1, 1, 6, 4, 1, 0, 7, 2,
//                0, 3, 9, 8, 7, 7, 0, 6, 9, 9, 7, 3, 6, 3, 4, 8, 6, 4, 3, 3, 2, 7, 8, 5, 8, 6, 0 }, 16);
    }

    private static void checkSolution(int[] nums, int expectedResult) {
        int result = solution.jump(nums);
        System.out.println(expectedResult == result);
//        System.out.println("   " + result);
    }
    
    private static int[] readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        String fileData;
        try {
            fileData = Files.readString(path, StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        int i = 0;
        StringBuilder wordBuilder = new StringBuilder();
        List<Integer> resultList = new ArrayList<>();
        while (i < fileData.length()) {
            char c = fileData.charAt(i);
            if (c == ',') {
                String word = wordBuilder.toString();
                wordBuilder = new StringBuilder();
                if (!word.isEmpty()) {
                    resultList.add(Integer.parseInt(word));
                }
            } else {
                wordBuilder.append(c);
            }
            i++;
        }
        String word = wordBuilder.toString();
        if (!word.isEmpty()) {
            resultList.add(Integer.parseInt(word));
        }
        int[] result = new int[resultList.size()];
        for(int j = 0; j < result.length; j++) {
            result[j] = resultList.get(j);
        }
        return result;
    }

}
