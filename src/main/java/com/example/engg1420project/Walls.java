package com.example.engg1420project;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Walls {
    private static final int GRID_SIZE = 10;
    private static final int CELL_SIZE = 80;
    int x;
    int y;

    public Walls(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void spawnWalls(GridPane grid) {

        Random random = new Random();

        int xT1 = random.nextInt(GRID_SIZE); // x for Treasure 1
        int yT1 = random.nextInt(GRID_SIZE);
        Walls newWall = new Walls(xT1, yT1);
        Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
        cell.setFill(Color.BLACK); // Using the first color for red blocks
        grid.add(cell, xT1, yT1);

    }
}
