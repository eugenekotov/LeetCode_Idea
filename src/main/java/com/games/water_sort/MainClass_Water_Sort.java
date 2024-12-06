package com.games.water_sort;

import com.games.water_sort.logic.ILogicController;
import com.games.water_sort.logic.impl.Logic_1To3;
import com.games.water_sort.logic.impl.Logic_2To2;
import com.games.water_sort.logic.impl.Logic_3To1;
import com.games.water_sort.model.*;

import java.util.List;

public class MainClass_Water_Sort {

    public static void main(String[] args) {
        Board board = new Board();
        board.containers.add(new Container(Color.YELLOW, Color.LIGHT_GREEN, Color.YELLOW, Color.VIOLET));
        board.containers.add(new Container(Color.GREEN, Color.BLUE, Color.BLUE, Color.BLUE));
        board.containers.add(new Container(Color.GREEN, Color.GREY, Color.DARK_BLUE, Color.DARK_GREEN));
        board.containers.add(new Container(Color.ORANGE, Color.LIGHT_GREEN, Color.DARK_GREEN, Color.LIGHT_GREEN));
        board.containers.add(new Container(Color.BLUE, Color.BROWN, Color.YELLOW, Color.GREEN));
        board.containers.add(new Container(Color.RED, Color.ORANGE, Color.DARK_BLUE, Color.LIGHT_GREEN));
        board.containers.add(new Container(Color.VIOLET, Color.GREY, Color.ORANGE, Color.BROWN));
        board.containers.add(new Container(Color.BROWN, Color.DARK_BLUE, Color.PINK, Color.RED));
        board.containers.add(new Container(Color.YELLOW, Color.DARK_GREEN, Color.PINK, Color.VIOLET));
        board.containers.add(new Container(Color.VIOLET, Color.GREY, Color.DARK_BLUE, Color.ORANGE));
        board.containers.add(new Container(Color.GREEN, Color.DARK_GREEN, Color.RED, Color.BROWN));
        board.containers.add(new Container(Color.PINK, Color.RED, Color.PINK, Color.GREY));
        board.containers.add(new Container());
        board.containers.add(new Container());
        Utils.printBoard(board);
        Controller controller = new Controller(new ILogicController[]{new Logic_1To3(), new Logic_3To1(), new Logic_2To2()});
        if (controller.tryToResolve(board, 0)) {
            System.out.println("I found a solution!");
            List<Step> steps = controller.getSteps();
            System.out.println("Steps: " +  steps.size());

        } else {
            System.out.println("Sorry, I didn't find any solution.");
        }
    }
}
