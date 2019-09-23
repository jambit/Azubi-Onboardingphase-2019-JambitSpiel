package com.jambit;

import java.util.HashMap;
import java.util.Scanner;

public class Kampf extends Main {
    Scanner scanner = new Scanner(System.in);
    public int gegnerGesundheit;
    public int spielerGesundheit;
    private boolean kampfLäuft;
    private static int auswahl;
    private static String name;
    Main main = new Main();
    HashMap<Integer, String> temporarySave = new HashMap<Integer, String>();


    public Kampf(String name) {
        this.name = name;
    }

    void executeFight() {
        System.out.println("Wähle deine Waffe!");
        int sprechenAuswahl;
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
            //Todo waffen verbrauchen nach benuzung

        }

        spielerGesundheit = main.player.gesundheit;
        switch (name) {
            case "Cherry":
                gegnerGesundheit = 1000;
                break;
            case "Alma":
                gegnerGesundheit = 200;
                break;
        }

        //while (kampfLäuft){

        System.out.println("Du hast noch " + spielerGesundheit + " Gesundheit");
        System.out.println("Dein Gegner hat " + gegnerGesundheit + " Gesundheit");
        System.out.println();
        //   }
    }
}