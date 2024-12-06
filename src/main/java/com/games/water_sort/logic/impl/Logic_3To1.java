package com.games.water_sort.logic.impl;

import com.games.water_sort.logic.ILogicController;
import com.games.water_sort.model.Board;
import com.games.water_sort.model.Color;
import com.games.water_sort.model.Container;
import com.games.water_sort.model.LogicResult;

import java.util.List;

public class Logic_3To1 extends AbstractLogicController implements ILogicController {

    @Override
    public LogicResult run(Board board) {
        LogicResult result = new LogicResult();
        result.stepCount = 0;
        boolean moved;
        do {
            moved = false;
            int iFrom = get3(board);
            if (iFrom != -1) {
                int iTo = getOnly1(board, board.containers.get(iFrom).peek());
                if (iTo != -1) {
                    board = move(board, iFrom, iTo, result);
                    board = move(board, iFrom, iTo, result);
                    board = move(board, iFrom, iTo, result);
                    moved = true;
                }
            }
        } while (moved);
        result.board = board;
        return result;
    }

    private int get3(Board board) {
        for (int i = 0; i < board.containers.size(); i++) {
            Container container = board.containers.get(i);
            if (container.size() >= 3) {
                List<Color> colors = container.getColorsList();
                if (colors.get(colors.size() - 1) == colors.get(colors.size() - 2) && colors.get(colors.size() - 1) == colors.get(colors.size() - 3)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int getOnly1(Board board, Color color) {
        for (int i = 0; i < board.containers.size(); i++) {
            Container container = board.containers.get(i);
            if (container.size() == 1 && container.peek() == color) {
                return i;
            }
        }
        return -1;
    }



}
