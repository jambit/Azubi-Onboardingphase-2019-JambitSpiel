


package com.jambit;

import java.util.Scanner;

public class Empfang extends Room {
    int position = 102;

    void execute(Player player) {
        spezial = "Badge abholen";
        raumName = "Empfang";
        Scanner abfrage = new Scanner(System.in);
        option(player, position);
        switch (auswahl) {
            case 3:
                if (!player.badge) {
                    System.out.println("Hallo " + player.name + ". Was machst du hier? Bist du ...");
                    System.out.println("[1] ... ein Besucher?");
                    System.out.println("oder ...");
                    System.out.println("[2] ... ein Mitarbeiter?");
                    int abfragea = abfrage.nextInt();
                    if (abfragea == 2) {
                        player.intelligenz += 7;
                        player.staerke += 7;
                        System.out.println("Du wurdest stärker und intelligenter. Allerdings bekommst du trotzdem nur ein Besucherbadge, da du deine Schlüsselkarte verloren hast.");
                    }
                    System.out.println("Hast du denn schon die Security Policy gelesen?");
                    System.out.println("ja/nein");
                    String gelesen = abfrage.next();
                    if (gelesen.equals("ja")) {
                        System.out.println("Wer ist der IT-Sicherheitsbeauftragte bei jambit?");
                        System.out.println("[1] Markus Hartinger");
                        System.out.println("[2] Adalbert Schmitt");
                        System.out.println("[3] Claus Gratzl");
                        System.out.println("[4] Peter Fellinger");
                        int sicherheitsbeauftragter = abfrage.nextInt();
                        if (sicherheitsbeauftragter != 3) {
                            System.out.println("Hast du die Security Policy etwa doch nicht gelesen? Schau doch nochmal nach.");
                        } else {
                            System.out.println("Letzte Frage: Möchstest du einen Kaffee?");
                            System.out.println("ja/nein");
                            String kaffee = abfrage.next();
                            if (kaffee.equals("ja")) {
                                System.out.println("Tipp: Du kannst dir in der Küche einen Kaffee machen.");
                            } else if (kaffee.equals("nein")) {
                                System.out.println("Dann halt nicht.");
                            }
                            player.badge = true;
                            System.out.println("Du hast dein Badge erhalten.");
                        }
                    } else if (gelesen.equals("nein")) {
                        System.out.println("Dann musst du sie zuerst lesen bevor du dein Badge bekommst.");
                    }
                } else {
                    System.out.println("Du hast bereits ein Badge");
                }
                break;
            case 4:
                player.position = 1;
                break;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    void setEmpfang() {
        gegenstaende.put("Banane", 1);
    }
}

