package com.games.water_sort.model;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private Utils() {
    }

    public static void printBoard(Board board) {
        String indent = "   ";
        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < Container.MAX_SIZE; i++) {
            sbList.add(new StringBuilder());
        }
        board.containers.forEach(container -> {
            List<Color> colors = container.getColors();
            for (int i = 0; i < Container.MAX_SIZE; i++) {
                if (colors.size() < Container.MAX_SIZE - i) {
                    sbList.get(i).append("__").append(indent);
                } else {
                    sbList.get(i).append(colors.get(Container.MAX_SIZE - 1 - i).getName()).append(indent);
                }
            }
        });
        for (StringBuilder sb: sbList) {
            System.out.println(sb.toString());
        }
    }
}
