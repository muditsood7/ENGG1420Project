package com.example.engg1420project;
import java.util.Scanner;
public class Game {


    public static void main(String[] args) {

        //creating player with default name player, inital money of 100, intial power 50
        Player player = new Player("Player", 80,100, 50 );

        // creating instances of weapons with corresponding prices and attack power
        Weapon sword = new Weapon("Sword", 50, 10);
        Weapon hammer = new Weapon("Hammer", 70, 15);
        Weapon bow = new Weapon("Bow and arrow", 60, 20);


        //displaying available weapons, names, prices and power
        System.out.println("Available Weapons:");
        System.out.println("1.  " + sword.getName() + "- $" + sword.getPrice() + "Attack power is " + sword.getAttackPower());
        System.out.println("2.  " + hammer.getName() + "- $" + hammer.getPrice() + "Attack power is " + hammer.getAttackPower());
        System.out.println("3.  " + bow.getName() + "- $" + bow.getPrice() + "Attack power is " + bow.getAttackPower());


        //allows user to choose which weapon they want to buy
        System.out.print("Enter the number of weapon you want to buy: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();


        //calls buy weapon method depending on choice of player
        if (choice == 1) {
            player.buyWeapon(sword);
        } else if (choice == 2) {
            player.buyWeapon(hammer);
        } else if (choice == 3) {
            player.buyWeapon(bow);
        } else {
            System.out.println("Invalid choice");
        }

        // displays players money after purchase
        System.out.println("Players money after purchase: $" + player.getMoney());
    }
}
