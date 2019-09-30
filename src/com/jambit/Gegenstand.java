package com.jambit;


import java.util.HashMap;
//1 = Normale Dinge
// 2 = Waffen

public class Gegenstand extends Personen {
    public static HashMap<String, Integer> kathegorie = new HashMap<String, Integer>();

    void setGegenstand() {
        kathegorie.put("Banane", 1);
        kathegorie.put("Kaffee", 1);
        kathegorie.put("Apfel", 1);
        kathegorie.put("Erdbeeren", 1);
        kathegorie.put("Spezi", 1);
        kathegorie.put("Laptop", 2);
        kathegorie.put("Handy", 2);
        kathegorie.put("Kugelschreiber", 2);
        kathegorie.put("Ladekabel", 2);
        kathegorie.put("Kuchen", 2);
        kathegorie.put("Feuerlöscher", 2);
    }

    void unseGegenstand(Player player, String gegenstandInUse) {
        switch (gegenstandInUse) {
            case "Banane":
                player.gesundheit += 10;
                player.hunger -= 30;
                break;
            case "Kaffee":
                player.hunger += 10;
                player.staerke += 7;
                break;
            case "Apfel":
                player.gesundheit += 30;
                player.hunger -= 30;
                break;
            case "Erdbeeren":
                player.hunger -= 30;
                player.gesundheit += 30;
                break;
            case "Spezi":
                player.staerke += 5;
                player.hunger -= 7;
                break;
            case "Kuchen":
                player.hunger += 5;
                player.staerke -= 3;
                player.intelligenz -= 1;
                player.gesundheit -= 5;
                break;
            case "Rucksack":
                player.inventoryWeapons += 1;
                player.inventoryGegenstände += 4;
                break;

        }
    }
}
