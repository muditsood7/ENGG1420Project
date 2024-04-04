package com.example.engg1420project;


import java.util.ArrayList;
import java.util.List;

public class MarketHouse {
    private final List<Weapon> availableWeapons;


    public MarketHouse() {
        this.availableWeapons = new ArrayList<>();

        initializeMarketItems();
    }

    private void initializeMarketItems() {
        availableWeapons.add(new Weapon("Sword", 50, 10));
        availableWeapons.add(new Weapon("Hammer", 70, 15));
        availableWeapons.add(new Weapon("Bow and Arrow", 60, 20)); // Corrected name

    }

    public List<Weapon> getAvailableWeapons() {
        return availableWeapons;
    }

    public void addWeapon(Weapon weapon) {
        availableWeapons.add(weapon);
    }


    public void removeWeapon(Weapon weapon) {
        availableWeapons.remove(weapon);
    }


}
