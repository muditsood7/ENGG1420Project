package com.example.engg1420project;

import java.util.Random;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

// traphouse class for trap locations in game

public class TrapHouse {

    private static final int TRAP_COUNT = 5;
    private static final int CELL_SIZE = 80;
    private static int moneyLost; // money lost in trap
    private static int powerLost; // power lost in trap
    public static void spawnTraps(GridPane grid) {

        Random random = new Random();

        for (int i = 0; i < TRAP_COUNT; i++) {
            int x = random.nextInt(MainMap.GRID_SIZE);
            int y = random.nextInt(MainMap.GRID_SIZE);
            Rectangle trap = new Rectangle(CELL_SIZE, CELL_SIZE, Color.RED);
            grid.add(trap, x, y);
        }

    }

    // constructor to initialize money lost and power lost

    public TrapHouse (int moneyLost, int powerLost){
        TrapHouse.moneyLost = moneyLost;
        TrapHouse.powerLost = powerLost;
    }

    //method to get how much money is lost
    public static int getMoneyLost() {
        return moneyLost;
    }

    // method to get how much power is lost
    public static int getPowerLost(){
        return powerLost;
    }
}