package com.jambit;

import java.util.Scanner;

public class ChefBuero extends Room {
    int position = 107;
    int zufallszahl;
    public static Scanner wickeln = new Scanner(System.in);

    void execute(Player player) {
        raumName = "Chef-Büro";
        spezial = "Einwickeln";
        option(player, position);
        switch (auswahl) {
            case 3:
                einwickeln();
                break;
            case 4:
                player.position = 7;
                break;
        }
    }

    void einwickeln(){
        System.out.println("Du darfst einen der Chefs einwickeln. Welchen von beiden möchtest du einwickeln?");
        int i = personPosition.antworten2("Harti", "Felli");
        switch (i){
            case 1:
                if (!Main.player.hartiEingewickelt){
                    zufallszahl = (int) (Math.random() * 2) + 1;
                    System.out.println("Gib 1 oder 2 ein");
                    int wharti = wickeln.nextInt();
                    if (zufallszahl == wharti){
                        Main.player.staerke += 10;
                        System.out.println("Du hast Harti erfolgreich eingewickelt. Dadurch hat sich deine Stärke zu " + Main.player.staerke + " erhöht.");
                        Main.player.hartiEingewickelt = true;
                    } else {
                        System.out.println("Du hast es leider nicht geschafft.");
                    }
                } else {
                    System.out.println("Du hast Harti bereits eingewickelt.");
                }
                break;
            case 2:
                if (!Main.player.felliEingewickelt){
                    zufallszahl = (int) (Math.random() * 2) + 1;
                    System.out.println(zufallszahl);
                    System.out.println("Gib 1 oder 2 ein");
                    int wfelli = wickeln.nextInt();
                    if (zufallszahl == wfelli){
                        Main.player.staerke += 10;
                        System.out.println("Du hast Felli erfolgreich eingewickelt. Dadurch hat sich deine Stärke zu " + Main.player.staerke + " erhöht.");
                        Main.player.felliEingewickelt = true;
                    } else {
                        System.out.println("Du hast es leider nicht geschafft.");
                    }
                } else {
                    System.out.println("Du hast Felli bereits eingewickelt.");
                }
                break;
        }
    }

    void setChefBuero(){
        gegenstaende.put("Handy", 2);
    }

}
