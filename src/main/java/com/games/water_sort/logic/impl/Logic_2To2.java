package com.games.water_sort.logic.impl;

import com.games.water_sort.logic.ILogicController;
import com.games.water_sort.model.Board;
import com.games.water_sort.model.Color;
import com.games.water_sort.model.LogicResult;

import java.util.List;

public class Logic_2To2 extends AbstractLogicController implements ILogicController {

    @Override
    public LogicResult run(Board board){
        LogicResult result = new LogicResult();
        result.stepCount = 0;
        boolean moved;
        do {
            moved = false;
            for (int iTo = 0; iTo < board.containers.size(); iTo++) {
                if (board.containers.get(iTo).hasOnlyTwoOfOneColor()) {
                    int iFrom = get2(board, iTo, board.containers.get(iTo).peek());
                    if (iFrom != -1) {
                        board = move(board, iFrom, iTo, result);
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

    private int get2(Board board, int excludeIndex, Color color) {
        // Ok if we have two colors in another container
        for (int i = 0; i < board.containers.size(); i++) {
            if (i != excludeIndex && board.containers.get(i).size() > 1) {
                List<Color> colors = board.containers.get(i).getColorsList();
                if (colors.get(colors.size() - 1) == color && colors.get(colors.size() - 2) == color) {
                    return i;
                }
            }
        }
        return -1;
    }

}
