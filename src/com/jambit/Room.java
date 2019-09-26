package com.jambit;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class Room {
    public static PersonPosition personPosition = new PersonPosition();
    static Scanner scanner = new Scanner(System.in);
    public static int auswahl;
    public static String spezial;
    public static String raumName;
    public static int sprechenAuswahl;
    HashMap<String, Integer> gegenstaende = new HashMap<String, Integer>();
    HashMap<Integer, String> temporarySave = new HashMap<Integer, String>();

    void option(Player player, int position) {
        System.out.println("Du befindest dich im " + raumName);
        System.out.println("[1] Umschauen");
        System.out.println("[2] Sprechen");
        System.out.println("[3] " + spezial);
        System.out.println("[4] Raum verlassen");
        System.out.println("[5] Inventar");
        System.out.println("[6] Status");
        auswahl = scanner.nextInt();
        switch (auswahl) {
            case 1:
                umschauen(player, position);
                break;
            case 2:
                sprechen(position);
                option(player, position);
                break;
            case 5:
                player.checkInventory();
                option(player, position);
                break;
            case 6:
                player.getStats();
                option(player, position);
                break;
            default:
                break;
        }
    }

    void umschauen(Player player, int position) {
        if (gegenstaende.isEmpty()) {
            System.out.println("Nichts mehr hier");
        } else {
            for (String i : gegenstaende.keySet()) {
                System.out.println(i + "   Anzahl:" + gegenstaende.get(i));
            }
        }
        if (personPosition.personPositionList.containsValue(position)) {
            for (Personen i : personPosition.personPositionList.keySet()) {
                if (i.position == position) {
                    System.out.println(i.name);
                }
            }
        }
        System.out.println("[1] Aufheben?");
        System.out.println("[2] Nichts machen");
        auswahl = scanner.nextInt();
        if (auswahl == 1) {
            aufheben(player, position);
        }

        option(player, position);
    }

    void sprechen(int position) {
        if (personPosition.personPositionList.containsValue(position)) {
            int anzahl = 1;
            for (Personen i : personPosition.personPositionList.keySet()) {
                if (i.position == position) {
                    System.out.println("[" + anzahl + "] " + i.name);
                    temporarySave.put(anzahl, i.name);
                    anzahl++;
                }
            }

            sprechenAuswahl = scanner.nextInt();
            personPosition.triggerPerson(temporarySave.get(sprechenAuswahl));
        } else {
            System.out.println("Keiner da");
        }
    }

    void aufheben(Player player, int position) {
        int anzahl = 1;
        for (String i : gegenstaende.keySet()) {
            System.out.println("[" + anzahl + "] " + i);
            temporarySave.put(anzahl, i);
            anzahl++;
        }
        sprechenAuswahl = scanner.nextInt();
        String x = temporarySave.get(sprechenAuswahl);

        for (String i : player.inventory.keySet()) {
            player.inventoryUsed = player.inventoryUsed + player.inventory.get(i);
        }
        for (String i : player.weaponsInventory.keySet()) {
            player.inventoryUsedWeapons = player.inventoryUsedWeapons + player.weaponsInventory.get(i);
        }

        if (Main.gegenstandListe.kathegorie.get(x) == 1) {
            if (player.inventoryUsed == player.inventoryGegenstände) {
                System.out.println("Kein Platz mehr im Inventar");
                option(player, position);
            } else {
                if (!player.inventory.containsKey(x)) {
                    player.inventory.put(x, 1);

                } else {
                    player.inventory.replace(x, player.inventory.get(x), (player.inventory.get(x) + 1));
                }
            }
        } else {
            if (player.inventoryUsedWeapons == player.inventoryWeapons) {
                System.out.println("Kein Platz mehr für weitere Waffen");
                option(player, position);
            } else {
                if (!player.weaponsInventory.containsKey(x)) {
                    player.weaponsInventory.put(x, 1);
                } else {
                    player.weaponsInventory.replace(x, player.weaponsInventory.get(x), (player.weaponsInventory.get(x) + 1));
                }
            }
        }

        if (gegenstaende.get(x) == 1) {
            gegenstaende.remove(x);
        } else {
            gegenstaende.replace(x, gegenstaende.get(x), gegenstaende.get(x) - 1);
        }
    }
}