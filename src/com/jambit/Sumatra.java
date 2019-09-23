
package com.jambit;

import java.util.Scanner;
import java.util.SortedMap;

public class Sumatra extends Room {
    boolean quiz = true;
    int position = 101;

    void execute(Player player) {
        raumName = "Sumatra";
        spezial = "Quiz";
        option(player, position);
        switch (auswahl) {
            case 3:
                if (quiz == true) {
                    setQuiz(player);
                    execute(player);
                } else {
                    System.out.println("Du hast das Quiz bereits gespielt.");
                    execute(player);
                }
                break;
            case 4:
                player.position = 1;
                break;
        }
    }

    void setQuiz(Player player) {
        System.out.println("Wie hieß das Café, indem die beiden Geschäftsführer von jambit auf den Firmennamen gekommen sind?");
        System.out.println("[1] Lotti");
        System.out.println("[2] kaffee & mehr");
        System.out.println("[3] Espresso Kolonial");
        System.out.println("[4] Colombo");
        if (scanner.nextInt() != 2) {
            System.out.println("Deine Antwort ist leider falsch.");
        } else {
            System.out.println("Was ist keine Verleihkategorie in den Jambit Leihangeboten?");
            System.out.println("[1] Babyzeug");
            System.out.println("[2] Hardware");
            System.out.println("[3] Reiseequipment");
            System.out.println("[4] Pflanzen");
            if (!(scanner.nextInt() == 4)) {
                System.out.println("Nope, versuchs noch einmal, villeicht mit confluence");
            } else {
                System.out.println("Wer ist kein/e Ausbilder/in bei jambit?");
                System.out.println("[1] Nina Hübner");
                System.out.println("[2] Michael Braun");
                System.out.println("[3] Elisabeth Maierbach");
                System.out.println("[4] Michael Kirsch");
                if (scanner.nextInt() != 1) {
                    System.out.println("Das ist flasch! Probier es nocheinmal.");
                } else {
                    player.intelligenz += 5;
                    System.out.println("Glückwunsch! Du bist schlauer geworden.");
                    quiz = false;
                }
            }
        }
    }

    void setSumatra() {
        gegenstaende.put("Apfel", 2);
    }
}


