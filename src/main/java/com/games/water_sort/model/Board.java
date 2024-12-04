package com.games.water_sort.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Board {

    public List<Container> containers = new ArrayList<>();

    public Board() {
    }

    public boolean isResolved() {
        boolean result = true;
        int i =0;
        while (i < containers.size()) {
            Container container = containers.get(i);
            if (container.isEmpty()) {
                i++;
            } else if (container.isResolved()) {
                containers.remove(i);
//                resolvedContainers.add(containers.remove(i));
            } else {
                result = false;
                i++;
            }
        }
        return result;
    }

    @Override
    public Board clone() {
        Board newBoard = new Board();
        containers.forEach(container -> newBoard.containers.add(container.clone()));
        return newBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        if (containers.size() != board.containers.size()) {
            return false;
        }
        for (int i = 0; i < containers.size(); i++) {
            if (!board.containers.contains(containers.get(i))) {
                return false;
            }
            if (!containers.contains(board.containers.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(containers);
    }
}
