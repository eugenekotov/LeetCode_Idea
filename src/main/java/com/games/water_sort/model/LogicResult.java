package com.games.water_sort.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LogicResult {

    public Board board;
    public int stepCount;
    public Set<Board> oldBoards = new HashSet<>();
    public List<Step> steps = new ArrayList<>();

}
