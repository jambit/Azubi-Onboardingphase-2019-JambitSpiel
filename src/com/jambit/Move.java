


package com.jambit;

import java.util.Scanner;

public class Move extends PersonPosition {
    public static Scanner scanner = new Scanner(System.in);
    private static int auswahl;

    void moveScreen(Player player) {
        System.out.println("[1] Nord");
        System.out.println("[2] Ost");
        System.out.println("[3] Süd");
        System.out.println("[4] West");
        System.out.println("[5] Inventar");
        System.out.println("[6] Status");
        auswahl = scanner.nextInt();
        switch (auswahl) {
            case 5:
                player.checkInventory();
                moveScreen(player);
                break;
            case 6:
                player.getStats();
                moveScreen(player);
                break;
            default:
                roomFinder(player);
                break;
        }
    }

    void roomFinder(Player player) {
        switch (player.position) {
            case 1:
                switch (auswahl) {
                    case 1:
                        player.position = 101;
                        break;
                    case 2:
                        player.position = 102;
                        break;
                    case 3:
                        if (!player.badge) {
                            System.out.println("Du hast keine Zugangsberechtigung. Hole dir erst ein Badge.");
                        } else {
                            player.position = 2;
                        }
                        break;
                    case 4:
                        System.out.println("Halt, du willst doch hier bleiben. Wähle eine andere Option.");
                        moveScreen(player);
                        break;
                }
                break;
            case 2:
                switch (auswahl) {
                    case 1:
                        player.position = 1;
                        break;
                    case 2:
                        player.position = 103;
                        break;
                    case 3:
                        player.position = 3;
                        break;
                    case 4:
                        System.out.println("Hier befindet sich eine Wand. Wähle eine andere Option.");
                        moveScreen(player);
                        break;
                }
                break;
            case 3:
                switch (auswahl) {
                    case 1:
                        player.position = 2;
                        break;
                    case 2:
                        player.position = 105;
                        break;
                    case 3:
                        if (!player.badge2) {
                            System.out.println("Mit diesem Badge hast du keine Zugangsberechtigung. Tipp: Suche Alma und hol dir von ihr eine Schlüsselkarte.");
                        } else {
                            player.position = 4;
                        }
                        break;
                    case 4:
                        player.position = 104;
                        break;
                }
                break;
            case 4:
                switch (auswahl) {
                    case 1:
                        player.position = 3;
                        break;
                    case 2:
                        System.out.println("Hier befindet sich eine Wand. Wähle eine andere Option.");
                        moveScreen(player);
                        break;
                    case 3:
                        player.position = 5;
                        break;
                    case 4:
                        player.position = 106;
                        break;
                }
                break;
            case 5:
                switch (auswahl){
                    case 1:
                        player.position = 4;
                        break;
                    case 2:
                        player.position = 107;
                        break;
                    case 3:
                        System.out.println("Mit dieser Aktion gehst du ins 2. Stockwerk. Welches Stockwerk wählst du?");
                        System.out.println("[1] 2. Stockwerk");
                        System.out.println("[2] 3. Stockwerk");
                        int stockwerk = scanner.nextInt();
                        switch (stockwerk){
                            case 1:
                                System.out.println("In welchen Raum möchtest du gehen?");
                                System.out.println("[1] Helpdesk");
                                System.out.println("[2] Kickerraum");
                                int raum = scanner.nextInt();
                                switch (raum){
                                    case 1:
                                        player.position = 201;
                                        break;
                                    case 2:
                                        player.position = 202;
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Du hast dich für das 3.Stockwerk entschieden.");
                                break;
                        }
                    case 4:
                        System.out.println("Hier befindet sich eine Wand. Wähle eine andere Option.");
                        moveScreen(player);
                        break;
                }
                break;
        }
    }
}
