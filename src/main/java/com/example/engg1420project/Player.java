package com.example.engg1420project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Player {
    private ImageView imageView;
    private int cellSize;

    private int x; // Current x position of the player
    private int y; // Current y position of the player

    public Player(String imagePath, int cellSize) {
        this.cellSize = cellSize;

        // Load player image
        Image image = new Image(getClass().getResource(imagePath).toString());
        imageView = new ImageView(image);
        imageView.setFitWidth(cellSize);
        imageView.setFitHeight(cellSize);

        //initial x and y positions of the player
        x = 0;
        y = 0;
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
}
