package com.games.water_sort;

import com.games.water_sort.logic.ILogicController;
import com.games.water_sort.model.Board;
import com.games.water_sort.model.LogicResult;
import com.games.water_sort.model.Step;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controller {

    private final Set<Board> oldBoards = new HashSet<>();
    private final ILogicController[] logicControllers;
    private final List<Step> steps = new ArrayList<>();

    public Controller(ILogicController[] logicControllers) {
        this.logicControllers = logicControllers;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public boolean tryToResolve(Board board, int stepsCount) {
        if (board.isResolved()) {
            System.out.println("Resolved on step " + stepsCount);
            return true;
        }
        // Try to use logic
        boolean moved = true;
        while (moved) {
            moved = false;
            for (ILogicController logicController: logicControllers) {
                LogicResult logicResult = logicController.run(board);
                if (logicResult.stepCount > 0) {
                    if (logicResult.board.isResolved()) {
                        return true;
                    }
                    board = logicResult.board;
                    oldBoards.addAll(logicResult.oldBoards);
                    steps.addAll(logicResult.steps);
                    stepsCount = stepsCount + logicResult.stepCount;
                    moved = true;
                }
            }
        }
        // Try to check all options
        for (int iFrom = 0; iFrom < board.containers.size(); iFrom++) {
            // Try to find place for each
            for (int iTo = 0; iTo < board.containers.size(); iTo++) {
                if (iFrom != iTo) {
                    if (tryToMove(board, iFrom, iTo, stepsCount)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private boolean tryToMove(Board board, int iFrom, int iTo, int stepsCount) {
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
        if (board.containers.get(iFrom).hasOnlyThreeOfOneColor()) {
            // Stupid move;
            return false;
        }
        // We can try to move
        board = move(board, iFrom, iTo);
//        System.out.println("Moved one from " + iFrom + " to " + iTo);
        if (oldBoards.contains(board)) {
            // We already tried it
            return false;
        }
        steps.add(new Step(iFrom, iTo, board.containers.get(iTo).peek()));
        oldBoards.add(board);
        boolean result = tryToResolve(board, stepsCount + 1);
        if (!result) {
            removeSteps(stepsCount);
        }
        return result;
    }

    private Board move(Board board, int iFrom, int iTo) {
        Board newBoard = board.clone();
        newBoard.containers.get(iTo).push(newBoard.containers.get(iFrom).pop());
        return newBoard;
    }

    private void removeSteps(int stepCount) {
        while (steps.size() > stepCount) {
            steps.remove(steps.size() - 1);
        }
    }

}
