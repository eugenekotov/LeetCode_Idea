package com.games.water_sort.logic.impl;

import com.games.water_sort.logic.ILogicController;
import com.games.water_sort.model.Board;
import com.games.water_sort.model.Color;
import com.games.water_sort.model.LogicResult;
import com.games.water_sort.model.Step;

public abstract class AbstractLogicController implements ILogicController {

    @Override
    public Board move(Board board, int iFrom, int iTo, LogicResult logicResult) {
        Board newBoard = board.clone();
        Color color = newBoard.containers.get(iFrom).peek();
        newBoard.containers.get(iTo).push(newBoard.containers.get(iFrom).pop());
        logicResult.stepCount++;
        logicResult.oldBoards.add(newBoard);
        logicResult.steps.add(new Step(iFrom, iTo, color));
        return newBoard;
    }
}
