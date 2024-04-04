package com.example.engg1420project;

import java.util.List;
import java.util.Scanner;

public class Game {


    public static void main(String[] args) {
        // Creating player with default name player, initial money of 100, initial power 50
        Player player = new Player("Player", 80, 100, 50);

        // Creating instance of MarketHouse
        MarketHouse marketHouse = new MarketHouse();

        // Display available weapons in the market
        System.out.println("Available Weapons in the Market:");
        // gets list of available weapons from market
        List<Weapon> availableWeapons = marketHouse.getAvailableWeapons();
        // loop through each weapon and display details
        for (int i = 0; i < availableWeapons.size(); i++) {
            Weapon weapon = availableWeapons.get(i);
            System.out.println((i + 1) + ". " + weapon.getName() + " - $" + weapon.getPrice() +
                    ", Attack power: " + weapon.getAttackPower());
        }

        // Allows user to choose which weapon they want to buy
        System.out.print("Enter the number of the weapon you want to buy: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        // calls buy weapon method depending on choice of player
        if (choice >= 1 && choice <= availableWeapons.size()) {
            Weapon selectedWeapon = availableWeapons.get(choice - 1);
            player.buyWeapon(selectedWeapon);
            System.out.println("You bought " + selectedWeapon.getName() + " for $" + selectedWeapon.getPrice());
        } else {
            System.out.println("Invalid choice");
        }

        // Displays player's money after purchase
        System.out.println("Player's money after purchase: $" + player.getMoney());
    }
}
