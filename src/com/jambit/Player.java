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
    int schwierigkeitsgrad;

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

        System.out.println("   oooo       .o.       ooo        ooooo oooooooooo.  ooooo ooooooooooooo");
        Thread.sleep(880);
        System.out.println("   `888      .888.      `88.       .888' `888'   `Y8b `888' 8'   888   `8 ");
        Thread.sleep(880);
        System.out.println("    888     .8\"888.      888b     d'888   888     888  888       888      ");
        Thread.sleep(880);
        System.out.println("    888    .8' `888.     8 Y88. .P  888   888oooo888'  888       888      ");
        Thread.sleep(880);
        System.out.println("    888   .88ooo8888.    8  `888'   888   888    `88b  888       888      ");
        Thread.sleep(880);
        System.out.println("    888  .8'     `888.   8    Y     888   888    .88P  888       888      ");
        Thread.sleep(880);
        System.out.println(".o. 88P o88o     o8888o o8o        o888o o888bood8P'  o888o     o888o     ");
        Thread.sleep(880);
        System.out.println("`Y888P                                                                    ");
        Thread.sleep(880);
        System.out.println("");
        System.out.println("Drücke eine Taste um fortzufahren");

        while (!scanner.hasNext()) {
            TimeUnit.SECONDS.sleep(1);
        }
        scanner.nextLine();

        System.out.println("Wähle einen Schwierigkeitsgrad:");
        System.out.println("[1] Baby (realistischer, vertretbarer Spielspaß)");
        System.out.println("[2] Mittel (so wurde das Spiel getestet, danach haben wir einen leichteren Modus erschaffen");
        System.out.println("[3] Schwer (Für Leute, welche Darksouls etwa 20 mal durchgespielt haben...)");
        System.out.println("[4] Todesmut (wird schwer. sehr schwer. villeicht unmöglich)");
        schwierigkeitsgrad = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Hallo Fremder, wilkommen bei Jambit!");
        System.out.println("Wie ist dein Name?");
        name = scanner.nextLine();
        System.out.println("Oh, du siehst jung aus, wie alt bist du?");

        int x = scanner.nextInt();
        if (x <= 40) {
            intelligenz = 40;
            staerke = 50;
        } else {
            intelligenz = 50;
            staerke = 40;
        }
        System.out.println("Bist du im Kick-it like jambit?");
        System.out.println("ja/nein");
        zwischenSpeicher = scanner.next();
        System.out.println("ok");
        if (zwischenSpeicher.equals("ja")) {
            intelligenz -= 5;
            staerke += 17;
        } else if (zwischenSpeicher.equals("nein")) {
            intelligenz += 10;
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

        switch (schwierigkeitsgrad) {
            case 1:
                intelligenz = intelligenz * 1.5;
                staerke = staerke * 1.5;
                break;
            case 2:

                break;
            case 3:
                intelligenz = intelligenz * 0.75;
                staerke = staerke * 0.75;
                break;
            case 4:
                intelligenz = intelligenz * 0.5;
                staerke = staerke * 0.5;
                break;
        }

        musikPlayer.stop();
    }

    void checkInventory() {
        inventoryUsed = 0;
        inventoryUsedWeapons = 0;
        for (String i : inventory.keySet()) {
            inventoryUsed = inventoryUsed + inventory.get(i);
        }
        for (String i : weaponsInventory.keySet()) {
            inventoryUsedWeapons = inventoryUsedWeapons + weaponsInventory.get(i);
        }

        System.out.println("Inventar hat noch " + (inventoryGegenstände - inventoryUsed) + " Platz");
        System.out.println("Du kannst noch " + (inventoryWeapons - inventoryUsedWeapons) + " Waffen tragen");
        if (inventory.isEmpty()) {
            System.out.println("Nichts dabei");
        } else {
            for (String i : inventory.keySet()) {
                System.out.println(i + "   " + inventory.get(i));
            }
            for (String i : weaponsInventory.keySet()) {
                System.out.println(i + " " + weaponsInventory.get(i));
            }
            System.out.println("Was willst du benutzen?");
            System.out.println("[1] ja");
            System.out.println("[2] nein");
            System.out.println("[3] Gegenstand fallen lassen");
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
            } else if (zwischenSpeicherZahlen == 3) {
                int anzahl = 1;

                System.out.println("Waffen oder normale Gegenstände?");
                System.out.println("[1] Waffen");
                System.out.println("[2] Normale Gegenstände");
                sprechenAuswahl = scanner.nextInt();
                scanner.nextLine();
                if (sprechenAuswahl == 2) {
                    for (String i : inventory.keySet()) {
                        System.out.println("[" + anzahl + "] " + i);
                        temporarySpeicher.put(anzahl, i);
                        anzahl++;
                    }
                    sprechenAuswahl = scanner.nextInt();
                    String x = temporarySpeicher.get(sprechenAuswahl);


                    if (inventory.get(x) == 1) {
                        inventory.remove(x);
                    } else {
                        inventory.replace(x, inventory.get(x), inventory.get(x) - 1);
                    }
                    if (Main.player.position > 100) {
                        switch (Main.player.position) {
                            case 101:
                                if (sumatra.gegenstaende.containsKey(x)) {
                                    sumatra.gegenstaende.replace(x, sumatra.gegenstaende.get(x), (sumatra.gegenstaende.get(x) + 1));
                                } else {
                                    sumatra.gegenstaende.put(x, 1);
                                }
                                break;
                            case 102:
                                if (empfang.gegenstaende.containsKey(x)) {
                                    empfang.gegenstaende.replace(x, empfang.gegenstaende.get(x), (empfang.gegenstaende.get(x) + 1));
                                } else {
                                    empfang.gegenstaende.put(x, 1);
                                }

                                break;
                            case 103:
                                if (taBuero.gegenstaende.containsKey(x)) {
                                    taBuero.gegenstaende.replace(x, taBuero.gegenstaende.get(x), (taBuero.gegenstaende.get(x) + 1));
                                } else {
                                    taBuero.gegenstaende.put(x, 1);
                                }
                                break;
                            case 104:
                                if (java.gegenstaende.containsKey(x)) {
                                    java.gegenstaende.replace(x, java.gegenstaende.get(x), (java.gegenstaende.get(x) + 1));
                                } else {
                                    java.gegenstaende.put(x, 1);
                                }

                                break;
                            case 105:
                                if (deli.gegenstaende.containsKey(x)) {
                                    deli.gegenstaende.replace(x, deli.gegenstaende.get(x), (deli.gegenstaende.get(x) + 1));
                                } else {
                                    deli.gegenstaende.put(x, 1);
                                }

                                break;
                            case 106:
                                if (kalimantan.gegenstaende.containsKey(x)) {
                                    kalimantan.gegenstaende.replace(x, kalimantan.gegenstaende.get(x), (kalimantan.gegenstaende.get(x) + 1));
                                } else {
                                    kalimantan.gegenstaende.put(x, 1);
                                }
                                break;
                            case 107:
                                if (chefBuero.gegenstaende.containsKey(x)) {
                                    chefBuero.gegenstaende.replace(x, chefBuero.gegenstaende.get(x), (chefBuero.gegenstaende.get(x) + 1));
                                } else {
                                    chefBuero.gegenstaende.put(x, 1);
                                }
                                break;
                            case 108:
                                if (finanzbuero.gegenstaende.containsKey(x)) {
                                    finanzbuero.gegenstaende.replace(x, finanzbuero.gegenstaende.get(x), (finanzbuero.gegenstaende.get(x) + 1));
                                } else {
                                    finanzbuero.gegenstaende.put(x, 1);
                                }
                                break;
                            case 201:
                                helpdesk.gegenstaende.put(x, 1);
                                break;
                            case 202:
                                kickerraum.gegenstaende.put(x, 1);
                                break;
                        }

                    } else {
                        switch (Main.player.position) {
                            case 1:
                                if (sumatra.gegenstaende.containsKey(x)) {
                                    sumatra.gegenstaende.replace(x, sumatra.gegenstaende.get(x), (sumatra.gegenstaende.get(x) + 1));
                                } else {
                                    sumatra.gegenstaende.put(x, 1);
                                }

                                break;
                            case 2:
                                if (taBuero.gegenstaende.containsKey(x)) {
                                    taBuero.gegenstaende.replace(x, taBuero.gegenstaende.get(x), (taBuero.gegenstaende.get(x) + 1));
                                } else {
                                    taBuero.gegenstaende.put(x, 1);
                                }
                                break;
                            case 3:
                                if (java.gegenstaende.containsKey(x)) {
                                    java.gegenstaende.replace(x, java.gegenstaende.get(x), (java.gegenstaende.get(x) + 1));
                                } else {
                                    java.gegenstaende.put(x, 1);
                                }
                                break;
                            case 4:
                                if (kalimantan.gegenstaende.containsKey(x)) {
                                    kalimantan.gegenstaende.replace(x, kalimantan.gegenstaende.get(x), (kalimantan.gegenstaende.get(x) + 1));
                                } else {
                                    kalimantan.gegenstaende.put(x, 1);
                                }
                                break;
                            case 6 | 7:
                                if (chefBuero.gegenstaende.containsKey(x)) {
                                    chefBuero.gegenstaende.replace(x, chefBuero.gegenstaende.get(x), (chefBuero.gegenstaende.get(x) + 1));
                                } else {
                                    chefBuero.gegenstaende.put(x, 1);
                                }
                                break;

                            case 8:
                                if (finanzbuero.gegenstaende.containsKey(x)) {
                                    finanzbuero.gegenstaende.replace(x, finanzbuero.gegenstaende.get(x), (finanzbuero.gegenstaende.get(x) + 1));
                                } else {
                                    finanzbuero.gegenstaende.put(x, 1);
                                }
                                break;
                            case 5:
                                if (helpdesk.gegenstaende.containsKey(x)) {
                                    helpdesk.gegenstaende.replace(x, helpdesk.gegenstaende.get(x), (helpdesk.gegenstaende.get(x) + 1));
                                } else {
                                    helpdesk.gegenstaende.put(x, 1);
                                }
                                break;
                        }
                    }
                } else {
                    for (String i : weaponsInventory.keySet()) {
                        System.out.println("[" + anzahl + "] " + i);
                        temporarySpeicher.put(anzahl, i);
                        anzahl++;
                    }
                    sprechenAuswahl = scanner.nextInt();
                    String x = temporarySpeicher.get(sprechenAuswahl);


                    if (weaponsInventory.get(x) == 1) {
                        weaponsInventory.remove(x);
                    } else {
                        weaponsInventory.replace(x, weaponsInventory.get(x), weaponsInventory.get(x) - 1);
                    }

                    if (Main.player.position > 100) {
                        switch (Main.player.position) {
                            case 101:
                                if (sumatra.gegenstaende.containsKey(x)) {
                                    sumatra.gegenstaende.replace(x, sumatra.gegenstaende.get(x), (sumatra.gegenstaende.get(x) + 1));
                                } else {
                                    sumatra.gegenstaende.put(x, 1);
                                }
                                break;
                            case 102:
                                if (empfang.gegenstaende.containsKey(x)) {
                                    empfang.gegenstaende.replace(x, empfang.gegenstaende.get(x), (empfang.gegenstaende.get(x) + 1));
                                } else {
                                    empfang.gegenstaende.put(x, 1);
                                }

                                break;
                            case 103:
                                if (taBuero.gegenstaende.containsKey(x)) {
                                    taBuero.gegenstaende.replace(x, taBuero.gegenstaende.get(x), (taBuero.gegenstaende.get(x) + 1));
                                } else {
                                    taBuero.gegenstaende.put(x, 1);
                                }
                                break;
                            case 104:
                                if (java.gegenstaende.containsKey(x)) {
                                    java.gegenstaende.replace(x, java.gegenstaende.get(x), (java.gegenstaende.get(x) + 1));
                                } else {
                                    java.gegenstaende.put(x, 1);
                                }

                                break;
                            case 105:
                                if (deli.gegenstaende.containsKey(x)) {
                                    deli.gegenstaende.replace(x, deli.gegenstaende.get(x), (deli.gegenstaende.get(x) + 1));
                                } else {
                                    deli.gegenstaende.put(x, 1);
                                }

                                break;
                            case 106:
                                if (kalimantan.gegenstaende.containsKey(x)) {
                                    kalimantan.gegenstaende.replace(x, kalimantan.gegenstaende.get(x), (kalimantan.gegenstaende.get(x) + 1));
                                } else {
                                    kalimantan.gegenstaende.put(x, 1);
                                }
                                break;
                            case 107:
                                if (chefBuero.gegenstaende.containsKey(x)) {
                                    chefBuero.gegenstaende.replace(x, chefBuero.gegenstaende.get(x), (chefBuero.gegenstaende.get(x) + 1));
                                } else {
                                    chefBuero.gegenstaende.put(x, 1);
                                }
                                break;
                            case 108:
                                if (finanzbuero.gegenstaende.containsKey(x)) {
                                    finanzbuero.gegenstaende.replace(x, finanzbuero.gegenstaende.get(x), (finanzbuero.gegenstaende.get(x) + 1));
                                } else {
                                    finanzbuero.gegenstaende.put(x, 1);
                                }
                                break;
                            case 201:
                                helpdesk.gegenstaende.put(x, 1);
                                break;
                            case 202:
                                kickerraum.gegenstaende.put(x, 1);
                                break;
                        }

                    } else {
                        switch (Main.player.position) {
                            case 1:
                                if (sumatra.gegenstaende.containsKey(x)) {
                                    sumatra.gegenstaende.replace(x, sumatra.gegenstaende.get(x), (sumatra.gegenstaende.get(x) + 1));
                                } else {
                                    sumatra.gegenstaende.put(x, 1);
                                }

                                break;
                            case 2:
                                if (taBuero.gegenstaende.containsKey(x)) {
                                    taBuero.gegenstaende.replace(x, taBuero.gegenstaende.get(x), (taBuero.gegenstaende.get(x) + 1));
                                } else {
                                    taBuero.gegenstaende.put(x, 1);
                                }
                                break;
                            case 3:
                                if (java.gegenstaende.containsKey(x)) {
                                    java.gegenstaende.replace(x, java.gegenstaende.get(x), (java.gegenstaende.get(x) + 1));
                                } else {
                                    java.gegenstaende.put(x, 1);
                                }
                                break;
                            case 4:
                                if (kalimantan.gegenstaende.containsKey(x)) {
                                    kalimantan.gegenstaende.replace(x, kalimantan.gegenstaende.get(x), (kalimantan.gegenstaende.get(x) + 1));
                                } else {
                                    kalimantan.gegenstaende.put(x, 1);
                                }
                                break;
                            case 6 | 7:
                                if (chefBuero.gegenstaende.containsKey(x)) {
                                    chefBuero.gegenstaende.replace(x, chefBuero.gegenstaende.get(x), (chefBuero.gegenstaende.get(x) + 1));
                                } else {
                                    chefBuero.gegenstaende.put(x, 1);
                                }
                                break;

                            case 8:
                                if (finanzbuero.gegenstaende.containsKey(x)) {
                                    finanzbuero.gegenstaende.replace(x, finanzbuero.gegenstaende.get(x), (finanzbuero.gegenstaende.get(x) + 1));
                                } else {
                                    finanzbuero.gegenstaende.put(x, 1);
                                }
                                break;
                            case 5:
                                if (helpdesk.gegenstaende.containsKey(x)) {
                                    helpdesk.gegenstaende.replace(x, helpdesk.gegenstaende.get(x), (helpdesk.gegenstaende.get(x) + 1));
                                } else {
                                    helpdesk.gegenstaende.put(x, 1);
                                }
                                break;
                        }
                    }
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
        System.out.println("");
        System.out.println("[1] Help");
        System.out.println("[2] Exit");
        int statusAuswahl = scanner.nextInt();
        switch (statusAuswahl) {
            case 1:
                System.out.println("Welche Hilfe brauchst du?");
                System.out.println("[1] allgemeine Info");
                System.out.println("[2] Kampfinfo");
                int hilfe = scanner.nextInt();
                switch (hilfe) {
                    case 1:
                        System.out.println("ALLGEMEINE INFO");
                        System.out.println("Die Räume oritntieren sich an den jambit-Geschäftsräumen. Wie die Räume genau verteilt sind musst du selber heraus finden.");
                        System.out.println("Um eine Zugangsbereichtigung für bestimmte Bereiche zu bekommen musst du dir erst ein/e Badge/Schlüsselkarte holen.");
                        System.out.println("Deine Gesundheit kann max. einen Wert von 150 erreichen. Alle anderen Werte sind unbegrenzt. Wenn deiner Hunger 100 erreicht stirbst du.");
                        System.out.println("");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        break;
                    case 2:
                        System.out.println("KAMPFINFO");
                        System.out.println("");
                        System.out.println("Es gibt 3 Angriffsarten, leicht mittel und schwer");
                        System.out.println("Die Wahrscheinlichkeit eines Treffers:");
                        System.out.println("Leicht: 0,8*Intelligenz/100");
                        System.out.println("Mittel: 0,6*Intelligenz/100");
                        System.out.println("Schwer: 0,3*Intelligenz/100");
                        System.out.println("");
                        System.out.println("Schaden:");
                        System.out.println("Leicht: 20*Stärke/10 + Waffenstärke*Intelligenz/10");
                        System.out.println("Mittel: 50*Stärke/10 + Waffenstärke*Intelligenz/10");
                        System.out.println("Schwer: 80*Stärke/10 + Waffenstärke*Intelligenz/10");
                        System.out.println("Dein Gegner hat eine ihm zutreffende Trefferwahrscheinlichkeit und Schaden");
                        System.out.println("");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        break;
                }
                break;
            case 2:
                break;
        }
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
