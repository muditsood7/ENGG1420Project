package com.example.engg1420project;

import java.util.List;
import java.util.Random;
//import java.util.Arrays;
//import java.util.TreeSet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.controlsfx.control.table.TableRowExpanderColumn;

public class MainMap extends Application {
    public static final int GRID_SIZE = 10;
    //private static final int GRID_SIZE = 10;
    private static final int CELL_SIZE = 80;
    private static final int WINDOW_WIDTH = GRID_SIZE * CELL_SIZE;
    private static final int WINDOW_HEIGHT = GRID_SIZE * CELL_SIZE;
    private TreasureHouse[]treasureHouses = new TreasureHouse[8];

    private Player player;

    @Override
    public void start(Stage stage) {
        // Load the background image
        Image backgroundImage = new Image(getClass().getResource("/images/map.png").toString());
        ImageView backgroundView = new ImageView(backgroundImage);

        // Create the root stack pane and add the background image
        StackPane root = new StackPane();
        root.getChildren().add(backgroundView);

        // Create the grid and add it to the root
        GridPane grid = createGrid();
        root.getChildren().add(grid);

        // Ensure the background image fits the grid
        backgroundView.fitWidthProperty().bind(root.widthProperty());
        backgroundView.fitHeightProperty().bind(root.heightProperty());

        treasureHouses[0] = TreasureHouse.spawnTreasure(grid, "Diamond Ring", 20);
        treasureHouses[1] = TreasureHouse.spawnTreasure(grid, "Jewel Encrusted Sword", 30);
        treasureHouses[2] = TreasureHouse.spawnTreasure(grid, "Golden Goblet", 15);
        treasureHouses[3] = TreasureHouse.spawnTreasure(grid, "Crystal Goblets", 12);
        treasureHouses[4] = TreasureHouse.spawnTreasure(grid, "Wooden Bow", 5);
        treasureHouses[5] = TreasureHouse.spawnTreasure(grid, "Paladin's Shield", 10);
        treasureHouses[6] = TreasureHouse.spawnTreasure(grid, "Golden Key", 17);
        treasureHouses[7] = TreasureHouse.spawnTreasure(grid, "Dragon Scroll", 25);

        Random random = new Random();
        for (int i = 0; i < random.nextInt(5); i++)
            Walls.spawnWalls(grid);

        player = new Player("/images/player.png", CELL_SIZE);
        grid.add(player.getImageView(), 0, 0);

        // mnm Load and add the player image at (0, 0)
        Image pawnImage = new Image(getClass().getResource("/images/player.png").toString());
        ImageView pawnImageView = new ImageView(pawnImage);
        pawnImageView.setFitWidth(CELL_SIZE);
       pawnImageView.setFitHeight(CELL_SIZE);
        grid.add(pawnImageView, 0, 0);

        // Load and add the landmark image at position (9, 9)
        Image landmarkImage = new Image(getClass().getResource("/images/landmark.png").toString());
        ImageView landmarkImageView = new ImageView(landmarkImage);
        landmarkImageView.setFitWidth(CELL_SIZE);
        landmarkImageView.setFitHeight(CELL_SIZE);
        grid.add(landmarkImageView, 9, 9);

        // Create the scene and set it to the stage
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Traveling Salesman Game");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(this::handleKeyPress);


    }

    // Method to create the grid
    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(1);
        grid.setVgap(1);
        grid.setStyle("-fx-grid-lines-visible: true; -fx-grid-line-color: black;");

        // Loop through each cell in the grid
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                // Create a transparent rectangle for each cell
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);
                cell.setFill(Color.TRANSPARENT);
                grid.add(cell, i, j);
                if (i == 4 && j == 4) {
                    cell.setFill(Color.YELLOW);
                }
            }
        }

        return grid;

    }

    private void handleKeyPress(KeyEvent event){
        KeyCode code = event.getCode();

        switch(code){
            case UP:
                player.moveUp();
                break;
            case DOWN:
                player.moveDown();
                break;
            case LEFT:
                player.moveLeft();
                break;
            case RIGHT:
                player.moveRight();
                break;
            default:

        }
    }

    public static void main(String[] args) {

        launch();
    }
}