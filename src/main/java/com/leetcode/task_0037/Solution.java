package com.leetcode.task_0037;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    class Position {
        int row;
        int col;

        public Position(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + col;
            result = prime * result + row;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Position other = (Position) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (col != other.col)
                return false;
            if (row != other.row)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "[row=" + row + ", col=" + col + "]";
        }

        private Solution getEnclosingInstance() {
            return Solution.this;
        }
    }

    boolean b = true;
    
    public void solveSudoku(char[][] board) {
        Map<Position, List<Character>> possibleVariants = generatePossibleVariants(board);
        // check empty cells
        if (!makeChecks(possibleVariants, board)) {
            return;
        }
     
        if (!possibleVariants.keySet().isEmpty()) {
            b = false;
            char[][] newBoard = solveSudoku(board, possibleVariants);
            copy(board, newBoard);
        }
    }

    private char[][] solveSudoku(char[][] board, Map<Position, List<Character>> possibleVariants) {
        // check all possible positions
        Set<Position> positions = possibleVariants.keySet();
        for (Position position : positions) {
            List<Character> variants = possibleVariants.get(position);
            for (Character c : variants) {
                Map<Position, List<Character>> possibleVariants2 = clone(possibleVariants);
                char[][] board2 = clone(board);
                if (!makeAnswer(position, c, board2, possibleVariants2)) {
                    continue;
                }
                if (possibleVariants2.keySet().isEmpty()) {
                    return board2;
                }
                if (!makeChecks(possibleVariants2, board2)) {
                    continue;
                }
                if (possibleVariants2.keySet().isEmpty()) {
                    return board2;
                }
                char[][] newBoard = solveSudoku(board2, possibleVariants2);
                if (newBoard != null) {
                    return newBoard;
                }
            }
        }
        return null;
    }

    private void copy(char[][] boardTo, char[][] boardFrom) {
        for (int i = 0; i < boardTo.length; i++) {
            boardTo[i] = boardFrom[i];
        }
    }

    private char[][] clone(char[][] board) {
        char[][] result = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            result[i] = board[i].clone();
        }
        return result;
    }

    private Map<Position, List<Character>> clone(Map<Position, List<Character>> possibleVariants) {
        Map<Position, List<Character>> result = new HashMap<>();
        for (Position position : possibleVariants.keySet()) {
            result.put(position, new ArrayList<Character>(possibleVariants.get(position)));
        }
        return result;
    }

    private boolean makeChecks(Map<Position, List<Character>> possibleVariants, char[][] board) {
        int oldEmptySize;
        do {
            oldEmptySize = possibleVariants.keySet().size();
            // Let's check do we have positions with only one variant
            for (Position position : new ArrayList<>(possibleVariants.keySet())) {
                if (possibleVariants.keySet().contains(position)) {
                    List<Character> vars = possibleVariants.get(position);
                    if (vars.size() == 1) {
                        if (!makeAnswer(position, vars.get(0), board, possibleVariants)) {
                            return false;
                        }
                        break;
                    }
                }
            }
            // Check rows. Do we have digit with only one possible position
            for (int row = 0; row < 9; row++) {
                if (!check2Row(row, board, possibleVariants)) {
                    return false;
                }
            }
            // Check cols. Do we have digit with only one possible position
            for (int col = 0; col < 9; col++) {
                if (!check2Col(col, board, possibleVariants)) {
                    return false;
                }
            }
            // Check squares. Do we have digit with only one possible position
            for (int partRow = 0; partRow < 3; partRow++) {
                for (int partCol = 0; partCol < 3; partCol++) {
                    if (!check2Square(partRow, partCol, board, possibleVariants)) {
                        return false;
                    }
                }
            }
        } while (oldEmptySize != possibleVariants.keySet().size());
        return true;
    }

    private Map<Position, List<Character>> generatePossibleVariants(char[][] board) {
        Map<Position, List<Character>> possibleVariants = new HashMap<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    Position position = new Position(row, col);
                    List<Character> variants = generateVariants(position, board);
                    possibleVariants.put(position, variants);
                }
            }
        }
        return possibleVariants;
    }

    private boolean check2Square(int partRow, int partCol, char[][] board,
            Map<Position, List<Character>> possibleVariants) {
        for (int i = 1; i < 10; i++) {
            char value = Character.forDigit(i, 10);
            Position pair = getOnePossibleSquare(partRow, partCol, value, possibleVariants);
            if (pair != null) {
                if (!makeAnswer(pair, value, board, possibleVariants)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Position getOnePossibleSquare(int partRow, int partCol, char value,
            Map<Position, List<Character>> possibleVariants) {

        int count = 0;
        Position resultPosition = null;

        int row1 = partRow * 3;
        int row2 = row1 + 3;

        int col1 = partCol * 3;
        int col2 = col1 + 3;

        for (int row = row1; row < row2; row++) {
            for (int col = col1; col < col2; col++) {

                Position pair = new Position(row, col);
                List<Character> vars = possibleVariants.get(pair);
                if (vars == null) {
                    continue;
                }
                if (vars.contains(value)) {
                    resultPosition = pair;
                    count++;
                    if (count > 1) {
                        return null;
                    }
                }
            }
        }

        if (count == 1) {
            return resultPosition;
        } else {
            return null;
        }
    }

    private boolean check2Col(int col, char[][] board, Map<Position, List<Character>> possibleVariants) {
        for (int i = 1; i < 10; i++) {
            char value = Character.forDigit(i, 10);
            int row = getOnePossibleRow(col, value, possibleVariants);
            if (row != -1) {
                if (!makeAnswer(new Position(row, col), value, board, possibleVariants)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getOnePossibleRow(int col, char value, Map<Position, List<Character>> possibleVariants) {
        int count = 0;
        int resultRow = -1;
        for (int row = 0; row < 9; row++) {
            Position pair = new Position(row, col);
            List<Character> vars = possibleVariants.get(pair);
            if (vars == null) {
                continue;
            }
            if (vars.contains(value)) {
                resultRow = row;
                count++;
                if (count > 1) {
                    return -1;
                }
            }
        }
        if (count == 1) {
            return resultRow;
        } else {
            return -1;
        }
    }

    private boolean check2Row(int row, char[][] board, Map<Position, List<Character>> possibleVariants) {
        for (int i = 1; i < 10; i++) {
            char value = Character.forDigit(i, 10);
            int col = getOnePossibleCol(row, value, possibleVariants);
            if (col != -1) {
                if (!makeAnswer(new Position(row, col), value, board, possibleVariants)) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getOnePossibleCol(int row, char value, Map<Position, List<Character>> possibleVariants) {
        int count = 0;
        int resultCol = -1;
        for (int col = 0; col < 9; col++) {
            Position pair = new Position(row, col);
            List<Character> vars = possibleVariants.get(pair);
            if (vars == null) {
                continue;
            }
            if (vars.contains(value)) {
                resultCol = col;
                count++;
                if (count > 1) {
                    return -1;
                }
            }
        }
        if (count == 1) {
            return resultCol;
        } else {
            return -1;
        }
    }

    private boolean makeAnswer(Position position, char value, char[][] board,
            Map<Position, List<Character>> possibleVariants) {
        possibleVariants.remove(position);
        board[position.row][position.col] = value;
        if (!removeFromVariantsInSquare(position, value, board, possibleVariants)) {
            return false;
        }
        if (!removeFromVariantsInVertical(position.col, value, board, possibleVariants)) {
            return false;
        }
        if (!removeFromVariantsInHorizontal(position.row, value, board, possibleVariants)) {
            return false;
        }
        return true;
    }

    private boolean removeFromVariantsInHorizontal(int row, char value, char[][] board,
            Map<Position, List<Character>> possibleVariants) {
        for (int col = 0; col < 9; col++) {
            if (!removeFromVariants(new Position(row, col), value, board, possibleVariants)) {
                return false;
            }
        }
        return true;
    }

    private boolean removeFromVariantsInVertical(int col, char value, char[][] board,
            Map<Position, List<Character>> possibleVariants) {
        for (int row = 0; row < 9; row++) {
            if (!removeFromVariants(new Position(row, col), value, board, possibleVariants)) {
                return false;
            }
        }
        return true;
    }

    private boolean removeFromVariantsInSquare(Position pair, char value, char[][] board,
            Map<Position, List<Character>> possibleVariants) {
        int partRow = pair.row / 3;
        int row1 = partRow * 3;
        int row2 = row1 + 3;

        int partCol = pair.col / 3;
        int col1 = partCol * 3;
        int col2 = col1 + 3;

        for (int row = row1; row < row2; row++) {
            for (int col = col1; col < col2; col++) {
                if (!removeFromVariants(new Position(row, col), value, board, possibleVariants)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean removeFromVariants(Position pair, char value, char[][] board,
            Map<Position, List<Character>> possibleVariants) {
        List<Character> vars = possibleVariants.get(pair);
        if (vars == null) {
            return true;
        }
        vars.remove(Character.valueOf(value));
        if (vars.size() == 0) {
            return false;
        }
        if (b && vars.size() == 1) {
            return makeAnswer(pair, vars.get(0), board, possibleVariants);
        }
        return true;
    }

    private List<Character> generateVariants(Position pair, char[][] board) {
        List<Character> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            char c = Character.forDigit(i, 10);
            if (hasInSquare(pair, c, board)) {
                continue;
            }
            if (hasInHorizontal(pair.row, c, board)) {
                continue;
            }
            if (hasInVertical(pair.col, c, board)) {
                continue;
            }
            result.add(c);
        }
        return result;
    }

    private boolean hasInSquare(Position pair, char value, char[][] board) {
        int partRow = pair.row / 3;
        int row1 = partRow * 3;
        int row2 = row1 + 3;

        int partCol = pair.col / 3;
        int col1 = partCol * 3;
        int col2 = col1 + 3;

        for (int row = row1; row < row2; row++) {
            for (int col = col1; col < col2; col++) {
                if (board[row][col] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasInVertical(int col, char value, char[][] board) {
        for (int row = 0; row < 9; row++) {
            char c = board[row][col];
            if (c == value) {
                return true;
            }
        }
        return false;
    }

    private boolean hasInHorizontal(int row, char value, char[][] board) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == value) {
                return true;
            }
        }
        return false;
    }

}
