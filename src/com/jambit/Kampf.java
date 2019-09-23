package com.jambit;

import java.util.HashMap;
import java.util.Scanner;

public class Kampf extends Main {
    Scanner scanner = new Scanner(System.in);
    int sprechenAuswahl;
    public double gegnerGesundheit;
    public double spielerGesundheit;
    private boolean kampfLäuft;
    private static int auswahl;
    private static String name;
    int waffenstaerke;
    int trefferWahscheinlichkeit;
    Main main = new Main();
    HashMap<Integer, String> temporarySave = new HashMap<Integer, String>();


    public Kampf(String name) {
        this.name = name;
    }

    void executeFight() {

        if (Main.kampfinfo) {
            System.out.println("KAMPFINFO");
            System.out.println("Es gibt 3 Angriffsarten, leicht mittel und schwer");
            System.out.println("Die Wahrscheinlichkeit eines Treffers:");
            System.out.println("Leicht: 0,3*Intelligenz/100");
            System.out.println("Mittel: 0,6*Intelligenz/100");
            System.out.println("Stärke: 0,8*Intelligenz/100");
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
            sprechenAuswahl = scanner.nextInt();
            waffenwaelen(sprechenAuswahl);
            //Todo waffen verbrauchen nach benuzung

        }

        spielerGesundheit = main.player.gesundheit;
        switch (name) {
            case "Cherry":
                gegnerGesundheit = 1000;
                break;
            case "Alma":
                gegnerGesundheit = 1;
                break;
        }

        //while (kampfLäuft){

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
                if (Math.random() >= 0.8) {
                    gegnerGesundheit -= 20 * Main.player.staerke / 10 + Main.player.intelligenz / 10 * waffenstaerke;
                    System.out.println("Treffer! Du hast" + 20 * Main.player.staerke / 10 + Main.player.intelligenz / 10 * waffenstaerke + " Schaden verursacht");

                }else {
                    System.out.println("Nicht getroffen!!!");
                }
                break;
            case 2:
                break;
            case 3:
                break;
        }


        //   }
    }

    void waffenwaelen(int wahl) {

    }
}