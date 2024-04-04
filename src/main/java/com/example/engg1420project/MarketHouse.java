package com.example.engg1420project;


import java.util.ArrayList;
import java.util.List;

import java.util.Random;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MarketHouse {
    private final List<Weapon> availableWeapons;
    private static final int CELL_SIZE = 80;


    // contructor to initialze markethouse and avaliable weapons
    public MarketHouse() {
        this.availableWeapons = new ArrayList<>();

        initializeMarketItems();
    }


    // initalize avaliable weapons in method
    private void initializeMarketItems() {
        availableWeapons.add(new Weapon("Sword", 50, 10));
        availableWeapons.add(new Weapon("Hammer", 70, 15));
        availableWeapons.add(new Weapon("Bow and Arrow", 60, 20)); // Corrected name

    }

    // getter to get list of available method
    public List<Weapon> getAvailableWeapons() {
        return availableWeapons;
    }

    // method to add weapons to available weapons to market if needed
    public void addWeapon(Weapon weapon) {
        availableWeapons.add(weapon);
    }

    // method to remove weapon from available weapons in market if needed
    public void removeWeapon(Weapon weapon) {
        availableWeapons.remove(weapon);
    }

    private static final int MARKET_COUNT = 5;



    // Method to spawn markets on the grid with uniform distribution

    public static void spawnMarkets(GridPane grid) {

        Random random = new Random();

        int marketsPlaced = 0;

        while (marketsPlaced < MARKET_COUNT) {

            int x = random.nextInt(MainMap.GRID_SIZE);

            int y = random.nextInt(MainMap.GRID_SIZE);

            if (grid.getChildren().stream().noneMatch(node -> GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) == y)) {

                Rectangle market = new Rectangle(CELL_SIZE, CELL_SIZE, Color.ORANGE);

                grid.add(market, x, y);

                marketsPlaced++;

            }

        }

    }


}
