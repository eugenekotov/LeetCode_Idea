package com.games.water_sort;

import com.games.water_sort.model.Board;
import com.games.water_sort.model.Color;
import com.games.water_sort.model.Container;
import com.games.water_sort.model.Step;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private Utils() {
    }

    public static void printBoard(Board board) {
        String indent = "   ";
        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < Container.MAX_SIZE + 1; i++) {
            sbList.add(new StringBuilder());
        }
        for (int containerIndex = 0; containerIndex < board.containers.size(); containerIndex++) {
            Container container = board.containers.get(containerIndex);
            List<Color> colors = container.getColorsList();
            for (int i = 0; i < Container.MAX_SIZE; i++) {
                if (colors.size() < Container.MAX_SIZE - i) {
                    sbList.get(i).append("__").append(getIndent(indent, containerIndex, board.containers.size()));
                } else {
                    sbList.get(i).append(colors.get(Container.MAX_SIZE - 1 - i).getName()).append(getIndent(indent, containerIndex, board.containers.size()));
                }
            }
            sbList.get(sbList.size() - 1).append(containerIndex < 10 ? containerIndex + " " : containerIndex).append(getIndent(indent, containerIndex, board.containers.size()));
        }
        for (StringBuilder sb : sbList) {
            System.out.println(sb.toString());
        }
    }

    public static void printSteps(List<Step> steps) {
        for (Step step: steps) {
            System.out.println(step.color + ": " + step.from + " -> " + step.to);
        }
    }

    private static String getIndent(String indent, int index, int size) {
        return index == size - 1 ? "" : indent;
    }
}
