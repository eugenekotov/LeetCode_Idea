package com.leetcode.solved.task_0036;

public class Solution {

    public boolean isValidSudoku(char[][] board) {

        char[] exists = new char[9];
        int pointer = 0;
        for (int i = 0; i < 9; i++) { // check vertical lines
            exists = new char[9];
            pointer = 0;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    for (int k = 0; k < exists.length; k++) {
                        if (board[i][j] == exists[k]) {
                            return false;
                        }
                    }
                }
                exists[pointer] = board[i][j];
                pointer++;
            }
        }
        for (int i = 0; i < 9; i++) { // check horizontal lines
            exists = new char[9];
            pointer = 0;
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    for (int k = 0; k < exists.length; k++) {
                        if (board[j][i] == exists[k]) {
                            return false;
                        }
                    }
                }
                exists[pointer] = board[j][i];
                pointer++;
            }
        }
        for (int l = 0; l < 3; l++) { // check boxes
            for (int m = 0; m < 3; m++) {
                exists = new char[9];
                pointer = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[(3 * l + i)][(3 * m + j)] != '.') {
                            for (int k = 0; k < exists.length; k++) {
                                if (board[(3 * l + i)][(3 * m + j)] == exists[k]) {
                                    return false;
                                }
                            }
                        }
                        exists[pointer] = board[(3 * l + i)][(3 * m + j)];
                        pointer++;
                    }
                }
            }
        }

        return true;
    }

}
