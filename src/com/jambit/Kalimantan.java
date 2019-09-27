package com.jambit;

import java.util.Scanner;

public class Kalimantan extends Room {
    int position = 106;
    Scanner binaercode = new Scanner(System.in);
    int dezimalzahl = 0;

    void execute(Player player) {
        raumName = "Kalimantan";
        spezial = "Binärcode";
        player.gesundheit--;
        System.out.println("Durch das betreten des Raums hast du Gesundheit verloren.");
        option(player, position);
        switch (auswahl) {
            case 3:
                binarcode(player);
                break;
            case 4:
                player.position = 4;
                break;
        }
    }

    void binarcode(Player player) {
        System.out.println("Wandle diesen Binärcode: 101, in Dezimalzahlen um. Aber Achtung: solange du es nicht richtig machst kommst du nicht weiter und du wirst immer hungriger.");
        dezimalzahl = binaercode.nextInt();
        if (dezimalzahl != 5) {
            binarcode(player);
            player.hunger += 2;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    void setKalimantan() {
        gegenstaende.put("Feuerlöscher", 2);
    }
}