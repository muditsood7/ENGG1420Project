package com.example.engg1420project;


import java.util.ArrayList;
import java.util.List;

public class MarketHouse {
    private final List<Weapon> availableWeapons;


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


}
