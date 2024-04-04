package com.example.engg1420project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.control.Button;



import java.util.Random;

public class MainMap extends Application {
    public static final int GRID_SIZE = 10;
    private static final int CELL_SIZE = 80;
    private static final int WINDOW_WIDTH = GRID_SIZE * CELL_SIZE;
    private static final int WINDOW_HEIGHT = GRID_SIZE * CELL_SIZE;

    private TreasureHouse[]treasureHouses = new TreasureHouse[8];
    private Player player1;
    private Player player2;
    private Label turnLabel;
    int player1Strength;
    int player2Strength;
    int player1Money;
    int player2Money;

    private Scoreboard scoreboard;
    private PlayerStatus playerStatus1;
    private PlayerStatus playerStatus2;

    // Getter method for GRID_SIZE
    public static int getGRID_SIZE() {
        return GRID_SIZE;
    }

    @Override
    public void start(Stage stage) {
        // Load the background image
        Image backgroundImage = new Image(getClass().getResource("/images/map.png").toString());
        ImageView backgroundView = new ImageView(backgroundImage);

        // Create the root stack pane and add the background image
        StackPane root = new StackPane();
        root.getChildren().add(backgroundView);

        // Ensure the background image fits the grid
        backgroundView.fitWidthProperty().bind(root.widthProperty());
        backgroundView.fitHeightProperty().bind(root.heightProperty());

        // Create the grid and add it to the root
        GridPane grid = createGrid();
        root.getChildren().add(grid);

        scoreboard = new Scoreboard();
        playerStatus1 = new PlayerStatus();
        playerStatus2 = new PlayerStatus();

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

        // Load and add the landmark image at position (9, 9)
        Image landmarkImage = new Image(getClass().getResource("/images/landmark.png").toString());
        ImageView landmarkImageView = new ImageView(landmarkImage);
        landmarkImageView.setFitWidth(CELL_SIZE);
        landmarkImageView.setFitHeight(CELL_SIZE);
        grid.add(landmarkImageView, 9, 9);

        // Add players
        player1 = new Player("/images/player.png", CELL_SIZE, 0,0);
        player2 = new Player("/images/player.png", CELL_SIZE, 0, 0);
        grid.add(player1.getImageView(), 0, 0);
        grid.add(player2.getImageView(), 1, 2);

        // Create the scoreboard
        scoreboard = new Scoreboard();
        scoreboard.addPlayer("Player 1");
        scoreboard.addPlayer("Player 2");

        // Create player statuses
        playerStatus1 = scoreboard.getPlayerStatus("Player 1");
        playerStatus2 = scoreboard.getPlayerStatus("Player 2");

        Label scoreboardLabel = new Label("Scoreboard");
        Label playerStatus1Label = new Label("Player 1 Status");
        Label playerStatus2Label = new Label("Player 2 Status");

        scoreboardLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        scoreboardLabel.setTextFill(Color.WHITE);
        playerStatus1Label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        playerStatus1Label.setTextFill(Color.WHITE);
        playerStatus2Label.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        playerStatus2Label.setTextFill(Color.WHITE);

        // Display the scoreboard and player statuses on the map
        root.getChildren().add(scoreboardLabel);
        root.getChildren().add(playerStatus1Label);
        root.getChildren().add(playerStatus2Label);

        // Position the components as needed
        StackPane.setAlignment(scoreboardLabel, Pos.TOP_LEFT);
        StackPane.setAlignment(playerStatus1Label, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(playerStatus2Label, Pos.BOTTOM_RIGHT);

        // Create the scene and set it to the stage
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Traveling Salesman Game");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        // Create the label
        Label turnLabel = new Label("Player 1's Turn");
        turnLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        turnLabel.setTextFill(Color.RED);

        // Add the label to the root stack pane
        root.getChildren().add(turnLabel);

        // Position the label as needed
        StackPane.setAlignment(turnLabel, Pos.TOP_CENTER);

        // Ensure the label is always visible
        turnLabel.setVisible(true);

        // Initialize player movement
        PlayerMovement playerMovement = new PlayerMovement(player1, player2, turnLabel);
        scene.setOnKeyPressed(playerMovement::handleKeyPress);

        // Add button for battle
        Button battleButton = new Button("Start Battle");
        battleButton.setOnAction(event -> startBattle());

        // Add the button to the root stack pane
        root.getChildren().add(battleButton);

        // Position the button as needed
        StackPane.setAlignment(battleButton, Pos.BOTTOM_CENTER);
    }

    private void startBattle() {
        Battle battle =  new Battle(player1Strength, player2Strength, player1Money, player2Money);
        if ((Math.abs(player1.x - player2.x) == 1) && (Math.abs(player1.y - player2.y) == 1)) {
            battle.moneyAndPowerTransfer();
        }
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

    public static void main(String[] args) {
        launch();
    }
}