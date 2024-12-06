package com.games.water_sort.logic.impl;

import com.games.water_sort.logic.ILogicController;
import com.games.water_sort.model.Board;
import com.games.water_sort.model.Color;
import com.games.water_sort.model.LogicResult;

public class Logic_1To3 extends AbstractLogicController implements ILogicController {

    @Override
    public LogicResult run(Board board) {
        // If we have onlyThreeColors, try to find last element and move it
        LogicResult result = new LogicResult();
        result.stepCount = 0;
        boolean moved;
        do {
            moved = false;
            for (int iTo = 0; iTo < board.containers.size(); iTo++) {
                if (board.containers.get(iTo).hasOnlyThreeOfOneColor()) {
                    int iFrom = getColorIndex(board, iTo, board.containers.get(iTo).peek());
                    if (iFrom != -1) {
                        board = move(board, iFrom, iTo, result);
                        moved = true;
                        break;
                    }
                }
            }
        } while (moved);
        result.board = board;
        return result;
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

}
