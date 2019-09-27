package com.jambit;

import java.util.Scanner;

public class Kickerraum extends Room {
    int position = 202;
    int zufallszahl;
    int match;
    int toreplayer = 0;
    int torematch = 0;
    public static Scanner kicker = new Scanner(System.in);

    void execute(Player player) {
        raumName = "Kickerraum";
        spezial = "kickern";
        option(player, position);
        switch (auswahl) {
            case 3:
                kickern();
                break;
            case 4:
                player.position = 5;
                System.out.println("Du befindest dich wieder im 3. Stockwerk.");
                break;
        }
    }

    void kickern() {
        while (torematch != 5 && toreplayer != 5) {
            zufallszahl = (int) (Math.random() * 20) + 1;
            System.out.println("Gib eine Zahl zwischen 1 und 20 ein.");
            match = kicker.nextInt();
            if (zufallszahl - match > 5 || zufallszahl - match < -5) {
                torematch++;
                System.out.println("Du hast ein Tor kassiert, es steht " + toreplayer + ":" + torematch + ", für dich.");
            } else {
                toreplayer++;
                System.out.println("Super! Du hast ein Tor geschossen, es steht " + toreplayer + ":" + torematch + ", für dich.");
            }
        }
        if (toreplayer == 5){
            Main.player.intelligenz += 10;
            System.out.println("Glückwunsch, du hast gewonnen. Du hast jetzt " + Main.player.intelligenz + " Intelligenz.");
            toreplayer = 0;
            torematch = 0;
        } else {
            Main.player.intelligenz -= 5;
            System.out.println("Schade, du hast verloren. Aber beim nächsten Mal läuft es bestimmt besser. Leider hast du Intelligenz verloren. Du hast jetzt " + Main.player.intelligenz + " Intelligenz.");
            toreplayer = 0;
            torematch = 0;
        }
    }

    void setKickerraum() {
        gegenstaende.put("Laptop",1);
    }
}
