package com.example.engg1420project;

public class TrapHouse {
    private static int moneyLost;
    private static int powerLost;

    public TrapHouse (int moneyLost, int powerLost){
        this.moneyLost = moneyLost;
        this.powerLost = powerLost;
    }

    public static int getMoneyLost() {
        return moneyLost;
    }

    public static int getPowerLost(){
        return powerLost;
    }


}
