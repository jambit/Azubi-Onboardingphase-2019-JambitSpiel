package com.jambit;

import java.util.concurrent.TimeUnit;

import java.util.HashMap;
import java.util.Scanner;

public class Kampf extends Main {
    Scanner scanner = new Scanner(System.in);
    int sprechenAuswahl;
    public double gegnerGesundheit;
    public double spielerGesundheit;
    private boolean kampfLäuft = true;
    private static int auswahl;
    private static String name;
    int waffenstaerke;
    int gegnerSchaden;
    double gegnerWahrscheinlichkeiten;
    int anzahlKämpfe;
    boolean keineFlucht;
    HashMap<Integer, String> temporarySave = new HashMap<Integer, String>();
    MusikPlayer musikPlayer = new MusikPlayer();


    public Kampf(String name) {
        this.name = name;
    }

    void executeFight() {
        Main.musikPlayer.stop();
        keineFlucht = true;
        musikPlayer.starteAbspielen("audio/EnergyBed2.mp3");
        if (Main.kampfinfo) {
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

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            Main.kampfinfo = false;
        }


        System.out.println("Wähle deine Waffe!");

        if (Main.player.weaponsInventory.isEmpty()) {
            System.out.println("Sorry, keine Waffe verfügbar");
        } else {
            int anzahl = 1;
            for (String i : Main.player.weaponsInventory.keySet()) {

                System.out.println("[" + anzahl + "] " + i);
                temporarySave.put(anzahl, i);
                anzahl++;
            }
            auswahl = scanner.nextInt();
            String ausgewählteWaffe = temporarySave.get(auswahl);
            waffenWaelen(ausgewählteWaffe);
            player.weaponsInventory.remove(ausgewählteWaffe);

        }

        spielerGesundheit = Main.player.gesundheit;
        switch (name) {
            case "Cherry":
                gegnerGesundheit = 3000;
                gegnerSchaden = 40;
                gegnerWahrscheinlichkeiten = 0.8;
                break;
            case "Alma":
                gegnerGesundheit = 1000;
                gegnerSchaden = 20;
                gegnerWahrscheinlichkeiten = 0.6;
                break;
            case "JambitMonster":
                gegnerGesundheit = 1000 + (anzahlKämpfe * 400);
                gegnerSchaden = 10 + (anzahlKämpfe * 7);
                gegnerWahrscheinlichkeiten = 0.5 + (anzahlKämpfe * 0.1);
                break;
            case "Max":
                gegnerGesundheit = 3000;
                gegnerSchaden = 20;
                gegnerWahrscheinlichkeiten = 0.7;
        }

        while (kampfLäuft == true) {

            System.out.println("Du hast noch " + spielerGesundheit + " Gesundheit");
            System.out.println("Dein Gegner hat " + gegnerGesundheit + " Gesundheit");
            System.out.println();
            System.out.println("Wähle deinen Angriff:");
            System.out.println("[1] Leicht");
            System.out.println("[2] Mittel");
            System.out.println("[3] Schwer");
            System.out.println("[4] Fliehen");
            auswahl = scanner.nextInt();
            switch (auswahl) {
                case 1:
                    if (Math.random() <= 0.8 * Main.player.intelligenz / 100) {
                        gegnerGesundheit -= ((20 * Main.player.staerke / 10) + (Main.player.intelligenz / 10 * waffenstaerke));
                        System.out.println("Treffer! Du hast" + 20 * Main.player.staerke / 10 + Main.player.intelligenz / 10 * waffenstaerke + " Schaden verursacht");

                    } else {
                        System.out.println("Nicht getroffen!!!");
                    }
                    break;
                case 2:
                    if (Math.random() <= 0.6 * Main.player.intelligenz / 100) {
                        gegnerGesundheit -= 50 * Main.player.staerke / 10 + Main.player.intelligenz / 10 * waffenstaerke;
                        System.out.println("Treffer! Du hast" + 50 * Main.player.staerke / 10 + Main.player.intelligenz / 10 * waffenstaerke + " Schaden verursacht");
                    } else {
                        System.out.println("Nicht getroffen!!!");
                    }
                    break;
                case 3:
                    if (Math.random() <= 0.3 * Main.player.intelligenz / 100) {
                        gegnerGesundheit -= 80 * Main.player.staerke / 10 + Main.player.intelligenz / 10 * waffenstaerke;
                        System.out.println("Treffer! Du hast" + 80 * Main.player.staerke / 10 + Main.player.intelligenz / 10 * waffenstaerke + " Schaden verursacht");

                    } else {
                        System.out.println("Nicht getroffen!!!");
                    }
                    break;
                case 4:
                    keineFlucht = false;
                    kampfLäuft = false;
                    break;
            }
            if (keineFlucht == true) {
                if (gegnerGesundheit <= 0) {
                    System.out.println("Gegner elimeniert");
                    switch (name) {
                        case "Cherry":
                            Main.personPosition.cherry.lebend = false;
                            break;
                        case "Alma":
                            Main.personPosition.alma.lebend = false;
                            break;
                        case "Max":
                            Main.personPosition.max.lebend = false;
                            break;
                    }
                    System.out.println("Du hast gewonnen!!!");
                    kampfLäuft = false;
                } else {
                    if (Math.random() >= gegnerWahrscheinlichkeiten) {
                        spielerGesundheit -= gegnerSchaden;
                        System.out.println("Der Gegner hat " + gegnerSchaden + " Schaden verursacht");
                        if (spielerGesundheit <= 0) {
                            sterbenImKampf();
                        }
                    } else {
                        System.out.println("Gegner hat dich verfehlt!");
                    }
                }
            }
        }
        Main.player.gesundheit = spielerGesundheit;
        musikPlayer.stop();
        Main.musikPlayer.starteAbspielen("audio/Soulstone.mp3");
        anzahlKämpfe++;
    }

    void waffenWaelen(String ausgewählteWaffe) {
        switch (ausgewählteWaffe) {
            case "Laptop":
                waffenstaerke = 20;
                break;
            case "Handy":
                waffenstaerke = 10;
                break;
            case "Kugelschreiber":
                waffenstaerke = 7;
                break;
            case "Ladekabel":
                waffenstaerke = 7;
                break;
            case "Feuerlöscher":
                waffenstaerke = 30;
                break;
        }
    }

    void sterbenImKampf() {
        musikPlayer.stop();
        System.out.println("\n" +
                "     )    )           (     (        (      \n" +
                "  ( /( ( /(           )\\ )  )\\ )     )\\ )   \n" +
                "  )\\()))\\())     (   (()/( (()/( (  (()/(   \n" +
                " ((_)\\((_)\\      )\\   /(_)) /(_)))\\  /(_))  \n" +
                "__ ((_) ((_)  _ ((_) (_))_ (_)) ((_)(_))_   \n" +
                "\\ \\ / // _ \\ | | | |  |   \\|_ _|| __||   \\  \n" +
                " \\ V /| (_) || |_| |  | |) || | | _| | |) | \n" +
                "  |_|  \\___/  \\___/   |___/|___||___||___/  \n" +
                "                                            \n");
        musikPlayer.starteAbspielen("audio/TheBigDecision.mp3");
        System.out.println("Drücke eine Taste um neu zu starten");

        while (!scanner.hasNext()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        scanner.nextLine();
        String[] args = new String[0];
        try {
            main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}