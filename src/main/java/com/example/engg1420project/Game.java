package com.example.engg1420project;
import java.util.Scanner;
public class Game {


    public static void main(String[] args) {


        Player player = new Player("Player", 80,100, 50 );

        Weapon sword = new Weapon("Sword", 50, 10);
        Weapon hammer = new Weapon("Hammer", 70, 15);
        Weapon bow = new Weapon("Bow and arrow", 60, 20);

        System.out.println("Available Weapons:");
        System.out.println("1.  " + sword.getName() + "- $" + sword.getPrice() + "Attack power is " + sword.getAttackPower());
        System.out.println("2.  " + hammer.getName() + "- $" + hammer.getPrice() + "Attack power is " + hammer.getAttackPower());
        System.out.println("3.  " + bow.getName() + "- $" + bow.getPrice() + "Attack power is " + bow.getAttackPower());

        System.out.print("Enter the number of weapon you want to buy: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            player.buyWeapon(sword);
        } else if (choice == 2) {
            player.buyWeapon(hammer);
        } else if (choice == 3) {
            player.buyWeapon(bow);
        } else {
            System.out.println("Invalid choice");
        }
        System.out.println("Players money after purchase: $" + player.getMoney());
    }
}
