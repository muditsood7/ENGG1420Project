package com.example.engg1420project;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PlayerMovement {
    private Player player;
    public PlayerMovement(Player player) {
        this.player = player;
    }

    public void handleKeyPress(KeyEvent event) {
        KeyCode code = event.getCode();

        // Adjust player position based on key pressed
        switch (code) {
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
                // Ignore other keys
        }
    }
}