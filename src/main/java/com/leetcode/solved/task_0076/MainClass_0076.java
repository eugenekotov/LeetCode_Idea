package com.leetcode.solved.task_0076;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainClass_0076 {

    private static Solution solution;

    public static void main(String[] args) {
        solution = new Solution();
        checkSolution("ADOBECODEBANC", "ABC", "BANC");
        checkSolution("a", "a", "a");
        checkSolution("a", "aa", "");
        checkSolution(readFromFile("src\\com\\leetcode\\task_0076\\dataS.txt"), readFromFile("src\\com\\leetcode\\task_0076\\dataT.txt"), "");
        checkSolution("a", "b", "");
        checkSolution("bba", "ab", "ba");
    }

    private static void checkSolution(String s, String t, String expectedResult) {
        System.out.println(solution.minWindow(s, t).equals(expectedResult));
    }

    private static String readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            return Files.readString(path, StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
