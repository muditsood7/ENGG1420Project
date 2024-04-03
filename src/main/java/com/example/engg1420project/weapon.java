package com.example.engg1420project;

import java.util.HashMap;
import java.util.Map;

class Weapon {
    private String name;
    private int price;
    private int attackPower;

    public Weapon(String name, int price, int attackPower) {
        this.name = name;
        this.price = price;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAttackPower() {
        return attackPower;
    }
}

