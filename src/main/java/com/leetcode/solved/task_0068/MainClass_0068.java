package com.leetcode.solved.task_0068;

import com.leetcode.Utils;

import java.util.List;

public class MainClass_0068 {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
//        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
//        int maxWidth1 = 16;
//        printList(solution.fullJustify(words1, maxWidth1));

//        String[] words2 = {"What","must","be","acknowledgment","shall","be"};
//        int maxWidth2 = 16;
//        printList(solution.fullJustify(words2, maxWidth2));

        String[] words3 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth3 = 20;
        Utils.printList(solution.fullJustify(words3, maxWidth3));


    }


}
