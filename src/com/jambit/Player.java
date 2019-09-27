/**
 * Player
 * is wichtig fürs Spiel
 */

package com.jambit;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Player extends PositionFinder {
    Scanner scanner = new Scanner(System.in);
    String zwischenSpeicher;
    HashMap<String, Integer> inventory = new HashMap<String, Integer>();
    HashMap<Integer, String> temporarySpeicher = new HashMap<Integer, String>();
    public static LinkedHashMap<String, Integer> weaponsInventory = new LinkedHashMap<String, Integer>();
    HashMap<String, Boolean> questList = new HashMap<String, Boolean>();
    int sprechenAuswahl;
    int zwischenSpeicherZahlen;
    double gesundheit = 100;
    int hunger = 0;
    double intelligenz = 0;
    String name;
    double staerke;
    int position;
    //TODO Wichtig auf False setzen

    boolean badge = false;
    boolean badge2 = false;
    boolean maus;
    boolean nasenspray;
    boolean hartiEingewickelt;
    boolean felliEingewickelt;
    boolean cappuccino;
    int inventoryGegenstände = 5;
    int inventoryWeapons = 2;
    int inventoryUsed;
    int inventoryUsedWeapons;

    public static MusikPlayer musikPlayer = new MusikPlayer();

    void start() throws InterruptedException {
        musikPlayer.starteAbspielen("audio/GoNotGentlyRedux.mp3");

        System.out.println("\n" +
                "   oooo       .o.       ooo        ooooo oooooooooo.  ooooo ooooooooooooo \n" +
                "   `888      .888.      `88.       .888' `888'   `Y8b `888' 8'   888   `8 \n" +
                "    888     .8\"888.      888b     d'888   888     888  888       888      \n" +
                "    888    .8' `888.     8 Y88. .P  888   888oooo888'  888       888      \n" +
                "    888   .88ooo8888.    8  `888'   888   888    `88b  888       888      \n" +
                "    888  .8'     `888.   8    Y     888   888    .88P  888       888      \n" +
                ".o. 88P o88o     o8888o o8o        o888o o888bood8P'  o888o     o888o     \n" +
                "`Y888P                                                                    \n" +
                "                                                                          \n" +
                "                                                                          \n");
        System.out.println("Drücke eine Taste um fortzufahren");
        while (!scanner.hasNext()) {
            TimeUnit.SECONDS.sleep(1);
        }
        scanner.nextLine();

        System.out.println("Hallo Fremder, wilkommen bei Jambit!");
        System.out.println("Wie ist dein Name?");
        name = scanner.nextLine();
        System.out.println("Oh, du siehst jung aus, wie alt bist du?");
        checkDAUint();
        int x = scanner.nextInt();
        if (x <= 40) {
            intelligenz = 20;
            staerke = 40;
        } else {
            intelligenz = 40;
            staerke = 20;
        }
        System.out.println("Bist du im Kick-it like jambit?");
        System.out.println("ja/nein");
        zwischenSpeicher = scanner.next();
        System.out.println("ok");
        if (zwischenSpeicher.equals("ja")) {
            intelligenz -= 7;
            staerke += 12;
        } else if (zwischenSpeicher.equals("nein")) {
            intelligenz += 5;
        } else {
            intelligenz -= 20;
            staerke -= 20;
            System.out.println("Ja dann halt nicht...");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        System.out.println("Hast du Hunger?");
        System.out.println("Nein, erst wenn er 100 erreicht, dann gehst du drauf");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("So, jetzt wünsche ich dir erstmal viel Spaß!!");
        musikPlayer.stop();
    }

    void checkInventory() {
        for (String i : inventory.keySet()) {
            inventoryUsed = inventoryUsed + inventory.get(i);
        }
        for (String i : weaponsInventory.keySet()) {
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
                if (gesundheit >= 150) {
                    gesundheit = 100;
                }
                if (hunger <= 0) {
                    hunger = 0;
                }
            }
        }
    }

    void checkQuest() {
        if (questList.isEmpty()) {
            System.out.println("Keine aktive quest");
        } else {
            for (String i : questList.keySet()) {
                System.out.println(i + "   " + questList.get(i));
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
