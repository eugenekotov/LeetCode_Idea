package com.games.water_sort.model;

import java.util.HashSet;
import java.util.Set;

public class Controller {

    private final Set<Board> oldBoards = new HashSet<>();

    public Controller() {
    }

    public boolean tryToResolve(Board board) {
        if (board.isResolved()) {
            return true;
        }
        // Try to use logic
        if (tryHasOnlyOneColor(board)) {
            return true;
        }
        // Try to take one from each container
        for (int iFrom = 0; iFrom < board.containers.size(); iFrom++) {
            // Try to find place for each
            for (int iTo = 0; iTo < board.containers.size(); iTo++) {
                if (iFrom != iTo) {
                    if (tryToMove(board, iFrom, iTo)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean tryHasOnlyOneColor(Board board) {
        // If we have onlyThreeColors, try to find last element and move it
        boolean moved;
        do {
            moved = false;
            for (int iTo = 0; iTo < board.containers.size(); iTo++) {
                if (board.containers.get(iTo).isHasOnlyThreeColor()) {

                    int iFrom = getColorIndex(board, iTo, board.containers.get(iTo).peek());
                    if (iFrom != -1) {
                        board.containers.get(iTo).push(board.containers.get(iFrom).pop());
                        oldBoards.add(board.clone());
                        moved = true;
                        System.out.println("Moved logic!!!!!!!!");
                        break;
                    }
                }
            }
            if (moved && board.isResolved()) {
                return true;
            }
        } while (moved);
        return board.isResolved();
    }

    private int getColorIndex(Board board, int excludeIndex, Color color) {
        for (int i = 0; i < board.containers.size(); i++) {
            if (i != excludeIndex) {
                if (!board.containers.get(i).isEmpty() && board.containers.get(i).peek() == color) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean tryToMove(Board board, int iFrom, int iTo) {
        if (board.containers.get(iFrom).isEmpty()) {
            // Nothing to take
            return false;
        }
        if (board.containers.get(iTo).isFull()) {
            // No place to put
            return false;
        }
        if (!board.containers.get(iTo).isEmpty() && board.containers.get(iFrom).peek() != board.containers.get(iTo).peek()) {
            // Not suitable color
            return false;
        }
        if (board.containers.get(iFrom).size() == 1 && board.containers.get(iTo).isEmpty()) {
            // Stupid move;
            return false;
        }
        if (board.containers.get(iFrom).isHasOnlyThreeColor()) {
            // Stupid move;
            return false;
        }
        // We can move
        Board newBoard = move(board, iFrom, iTo);
        if (oldBoards.contains(newBoard)) {
            // We already tried it
            return false;
        }
        oldBoards.add(newBoard);
        System.out.println("Moved from " + iFrom + " to " + iTo);
        System.out.println("Old boards count " + oldBoards.size());
        Utils.printBoard(newBoard);
        return tryToResolve(newBoard);
    }

    private Board move(Board board, int iFrom, int iTo) {
        Board newBoard = board.clone();
        newBoard.containers.get(iTo).push(newBoard.containers.get(iFrom).pop());
        return newBoard;
    }

}
