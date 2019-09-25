package com.jambit;

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
    Main main = new Main();
    HashMap<Integer, String> temporarySave = new HashMap<Integer, String>();
    MusikPlayer musikPlayer = new MusikPlayer();

    public Kampf(String name) {
        this.name = name;
    }

    void executeFight() {
        Main.musikPlayer.stop();
        musikPlayer.starteAbspielen("audio/harold-faltermeyer-axel-f-1984-beverly-hills-cop-soundtrack.mp3");
        if (Main.kampfinfo) {
            System.out.println("KAMPFINFO");
            System.out.println("Es gibt 3 Angriffsarten, leicht mittel und schwer");
            System.out.println("Die Wahrscheinlichkeit eines Treffers:");
            System.out.println("Schwer: 0,3*Intelligenz/100");
            System.out.println("Mittel: 0,6*Intelligenz/100");
            System.out.println("Leicht: 0,8*Intelligenz/100");
            System.out.println("");
            System.out.println("Schaden:");
            System.out.println("Leicht: 20*Stärke/10 + Waffenstärke*Intelligenz/10");
            System.out.println("Mittel: 50*Stärke/10 + Waffenstärke*Intelligenz/10");
            System.out.println("Schwer: 80*Stärke/10 + Waffenstärke*Intelligenz/10");
            System.out.println("Dein Gegner hat eine ihm zutreffende Trefferwahrscheinlichkeit und Schaden");

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
            waffenwaelen(ausgewählteWaffe);
            player.weaponsInventory.remove(ausgewählteWaffe);

        }

        spielerGesundheit = Main.player.gesundheit;
        switch (name) {
            case "Cherry":
                gegnerGesundheit = 1000;
                gegnerSchaden = 20;
                gegnerWahrscheinlichkeiten = 0.8;
                break;
            case "Alma":
                gegnerGesundheit = 1;
                gegnerSchaden = 20;
                gegnerWahrscheinlichkeiten = 0.6;
                break;
            case "JambitMonster":
                gegnerGesundheit = 500 + (anzahlKämpfe * 150);
                gegnerSchaden = 10 + (anzahlKämpfe * 7);
                gegnerWahrscheinlichkeiten = 0.5 + (anzahlKämpfe * 0.1);
                break;
        }

        while (kampfLäuft == true) {

            System.out.println("Du hast noch " + spielerGesundheit + " Gesundheit");
            System.out.println("Dein Gegner hat " + gegnerGesundheit + " Gesundheit");
            System.out.println();
            System.out.println("Wähle deinen Angriff:");
            System.out.println("[1] Leicht");
            System.out.println("[2] Mittel");
            System.out.println("[3] Schwer");
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

            }
            if (gegnerGesundheit <= 0) {
                System.out.println("Gegner elimeniert");
                switch (name) {
                    case "Cherry":
                        Main.personPosition.cherry.lebend = false;
                        break;
                    case "Alma":
                        Main.personPosition.cherry.lebend = false;
                        break;
                }
                System.out.println("Du hast gewonnen!!!");
                kampfLäuft = false;
            } else {
                if (Math.random() >= gegnerWahrscheinlichkeiten) {
                    spielerGesundheit -= gegnerSchaden;
                    System.out.println("Der Gegner hat " + gegnerSchaden + " verursacht");
                    if (spielerGesundheit <= 0) {
                        sterbenImKampf();
                    }
                } else {
                    System.out.println("Gegner hat dich verfehlt!");
                }
            }
        }
        Main.player.gesundheit = spielerGesundheit;
        musikPlayer.stop();
        Main.musikPlayer.starteAbspielen("audio/Scottish Battle Music - William Wallace.mp3");
        anzahlKämpfe++;
    }

    void waffenwaelen(String ausgewählteWaffe) {
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
                waffenstaerke = 2;
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
        musikPlayer.starteAbspielen("audio/Always Look on the Bright Side of Life.mp3");
    }
}