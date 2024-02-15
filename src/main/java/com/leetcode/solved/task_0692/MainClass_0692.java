package com.leetcode.solved.task_0692;

import java.util.Arrays;
import java.util.List;

public class MainClass_0692 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        System.out.println(checkSolution(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2,
                new String[] { "i", "love" }));
    }

    private static boolean checkSolution(String[] words, int k, String[] expRes) {
        List<String> res = solution.topKFrequent(words, k);
        List<String> expectedList = Arrays.asList(expRes);
        return res.equals(expectedList);
    }

}
