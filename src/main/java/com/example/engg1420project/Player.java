package com.example.engg1420project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.util.HashMap;
import java.util.Map;

import static com.example.engg1420project.TrapHouse.*;
import static com.example.engg1420project.TrapHouse.getPowerLost;

public class Player {
    private ImageView imageView;
    private int cellSize;

    public int x; // Current x position of the player
    public int y; // Current y position of the player

    private int money;
    private int power;

    private Map<String, Weapon> inventory;

    public Player(String imagePath, int cellSize, int initalMoney, int intialPower) {
        this.cellSize = cellSize;

        // Load player image
        Image image = new Image(getClass().getResource(imagePath).toString());
        imageView = new ImageView(image);
        imageView.setFitWidth(cellSize);
        imageView.setFitHeight(cellSize);

        //initial x and y positions of the player
        x = 0;
        y = 0;


        money = initalMoney;
        power = intialPower;
        inventory = new HashMap<>();
    }


    //method to get the imageview of the player
    public ImageView getImageView() {
        return imageView;
    }

    //methods to move player in specific directions
    public void moveUp() {
        if (y > 0) {
            y--;
            updatePosition();
        }
    }

    public void moveDown() {
        if (y < MainMap.GRID_SIZE - 1) {
            y++;
            updatePosition();
        }
    }

    public void moveLeft() {
        if (x > 0) {
            x--;
            updatePosition();
        }
    }

    public void moveRight() {
        if (x < MainMap.GRID_SIZE - 1) {
            x++;
            updatePosition();
        }
    }

    //method to update the position depending on the
    private void updatePosition() {
        //sets the column index and row index of the player
        GridPane.setColumnIndex(imageView, x);
        GridPane.setRowIndex(imageView, y);


    }

    // method to enter trap house and handle consequences for entering trap house
    public void enterTrapHouse(TrapHouse trapHouse) {

        System.out.println("Entering Trap house....");
        money = money - getMoneyLost();
        power = power - getPowerLost();
        System.out.println("Lost money: "+ getMoneyLost()+"Lost power: "+ getPowerLost());
}

    // method to buy a weapon
    public void buyWeapon(Weapon weapon) {
        if (money >= weapon.getPrice()) {
            money -= weapon.getPrice();
            inventory.put(weapon.getName(), weapon);
            System.out.println("Bought " + weapon.getName() + " for $" + weapon.getPrice());
        } else {
            System.out.println("Insufficient funds to buy " + weapon.getName());
        }
    }


    // method to enter trap house



    // method to interact with wall house
    public void interactWithWallHouse(){
        System.out.println("You encountered a wall house. No assets are inside.");
    }

    // Method to get player's money
    public int getMoney() {
        return money;
    }

    // method to get players power
    public int getPower(){
        return power;
    }

}