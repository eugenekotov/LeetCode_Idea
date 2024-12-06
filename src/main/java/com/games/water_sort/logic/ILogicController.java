package com.games.water_sort.logic;

import com.games.water_sort.model.Board;
import com.games.water_sort.model.LogicResult;

public interface ILogicController {

    LogicResult run(Board board);

    Board move(Board board, int iFrom, int iTo, LogicResult logicResult);
}
