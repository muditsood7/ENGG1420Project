package com.example.engg1420project;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PlayerMovement {
    private Player player1;
    //private Player player1;
    private Player player2;
    private boolean player1Turn = true;
    private Label turnLabel;

    //Player player1 = new Player("player.png", 80, 0, 0);


    public PlayerMovement(Player player1, Player player2, Label turnLabel) {
        this.player1 = player1;
        this.player2 = player2;
        this.turnLabel = turnLabel;
    }

    public void handleKeyPress(KeyEvent event) {
        KeyCode code = event.getCode();

        if (player1Turn) {
            switch (code) {
                case UP:
                    player1.moveUp();
                    break;
                case DOWN:
                    player1.moveDown();
                    break;
                case LEFT:
                    player1.moveLeft();
                    break;
                case RIGHT:
                    player1.moveRight();
                    break;
                default:
                    // Ignore other keys
            }
            turnLabel.setText("Player 2's Turn");
        } else {
            switch (code) {
                case UP:
                    player2.moveUp();
                    break;
                case DOWN:
                    player2.moveDown();
                    break;
                case LEFT:
                    player2.moveLeft();
                    break;
                case RIGHT:
                    player2.moveRight();
                    break;
                default:
                    // Ignore other keys
            }
            turnLabel.setText("Player 1's Turn");
        }

        // Switch turn
        player1Turn = !player1Turn;
    }
}
