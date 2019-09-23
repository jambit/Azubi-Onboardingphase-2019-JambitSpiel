/**
 * Player
 *is wichtig fürs Spiel
 */

package com.jambit;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.HashMap;

public class Player extends PositionFinder {
    Scanner scanner = new Scanner(System.in);
    String zwischenSpeicher;
    HashMap<String, Integer> inventory = new HashMap<String, Integer>();
    HashMap<Integer, String> temporarySpeicher = new HashMap<Integer, String>();
    public static LinkedHashMap<String, Integer> weaponsInventory = new LinkedHashMap<String, Integer>();
    int sprechenAuswahl;
    int zwischenSpeicherZahlen;
    int gesundheit = 10;
    int hunger = 0;
    int intelligenz = 0;
    String name;
    int staerke;
    int position;
    boolean badge = false;
    boolean badge2 = false;
    int inventoryGegenstände = 5;
    int inventoryWeapons = 2;
    int inventoryUsed;
    int inventoryUsedWeapons;

    void start() {
        /**
         * initialisiert ein Intro, welches Variablen seztzt
         *
         */
        System.out.println("Hallo Fremder, wilkommen bei Jambit!");
        System.out.println("Wie ist dein Name?");
        name = scanner.nextLine();
        System.out.println("Oh, du siehst jung aus, wie alt bist du?");
        checkDAUint();
        int x = scanner.nextInt();
        if (x <= 40) {
            intelligenz = 8;
            staerke = 12;
        } else {
            intelligenz = 12;
            staerke = 8;
        }
        System.out.println("Bist du im Kick-it like jambit?");
        System.out.println("ja/nein");
        zwischenSpeicher = scanner.next();
        System.out.println("ok");
        if (zwischenSpeicher.equals("ja")) {
            intelligenz += -1;
            staerke += 2;
        } else if (zwischenSpeicher.equals("nein")) {
            intelligenz++;
        } else {
            intelligenz -= 5;
            staerke -= 2;
            System.out.println("Ja dann halt nicht...");
        }
        System.out.println("Hast du Hunger?");
        System.out.println("Nein, erst wenn er 60 erreicht, dann gehst du drauf");
        System.out.println("So, jetzt wünsche ich dir erstmal viel Spaß!!");
    }

    void checkInventory() {
        for (String i : inventory.keySet()) {
            inventoryUsed = inventoryUsed + inventory.get(i);
        }
        for (String i : weaponsInventory.keySet()){
            inventoryUsedWeapons = inventoryUsedWeapons + weaponsInventory.get(i);
        }

        System.out.println("Inventar hat noch " + (inventoryGegenstände - inventoryUsed) + " Platz");
        System.out.println("Du kannst noch " + (inventoryWeapons - weaponsInventory.size()) + " Waffen tragen");
        if (inventory.isEmpty()) {
            System.out.println("Nichts dabei");
        } else {
            for (String i : inventory.keySet()) {
                System.out.println(i + "   " + inventory.get(i));
            }
            System.out.println("Was willst du was benutzen?");
            System.out.println("[1] ja");
            System.out.println("[2] nein");
            zwischenSpeicherZahlen = scanner.nextInt();
            System.out.println("ok");
            if (zwischenSpeicherZahlen == 1) {
                int anzahl = 1;
                for (String i : inventory.keySet()) {
                    System.out.println("[" + anzahl + "] " + i);
                    temporarySpeicher.put(anzahl, i);
                    anzahl++;
                }
                sprechenAuswahl = scanner.nextInt();
                String x = temporarySpeicher.get(sprechenAuswahl);
                Main.gegenstandListe.unseGegenstand(Main.player, x);

                if (inventory.get(x) == 1) {
                    inventory.remove(x);
                } else {
                    inventory.replace(x, inventory.get(x), inventory.get(x) - 1);
                }
            }
        }
    }

    void getStats() {
        System.out.println("Hunger:" + hunger);
        System.out.println("Gesundheit:" + gesundheit);
        System.out.println("Intelligenz:" + intelligenz);
        System.out.println("Stärke:" + staerke);
    }

    void checkDAUint() {
        if (!scanner.hasNextInt()) {
            System.out.println("Wie bitte?");
            if (!scanner.hasNextInt()) {
                System.out.println("Mimmst du das hier nicht ernst, oder was?");
                if (!scanner.hasNextInt()) {
                    System.out.println("Nö");
                    System.exit(0);
                }
            }
        }
    }
}
