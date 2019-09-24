package com.jambit;

public class Finanzbuero extends Room {
    int position = 107;
    boolean matheaufgaben = true;

    void execute(Player player) {
        raumName = "Finanzbüro";
        spezial = "Matheaufgaben";
        option(player, position);
        switch (auswahl) {
            case 3:
                setMatheaufgaben(player);
                execute(player);
                break;
            case 4:
                player.position = 5;
                break;
        }
    }

    void setMatheaufgaben(Player player) {
        System.out.println("Löse folgende Matheaufgaben richtig:");
        System.out.println("5 * 3 = ?");
        System.out.println("[1] 4");
        System.out.println("[2] 8");
        System.out.println("[3] 2");
        System.out.println("[4] 15");
        if (scanner.nextInt() != 4) {
            System.out.println("Deine Antwort ist leider falsch.");
        } else {
            System.out.println("81 / 9 = ?");
            System.out.println("[1] 72");
            System.out.println("[2] 9");
            System.out.println("[3] 90");
            System.out.println("[4] 729");
            if (!(scanner.nextInt() == 2)) {
                System.out.println("Nope, versuchs noch einmal, villeicht mit confluence");
            } else {
                System.out.println("13 * 8 = ?");
                System.out.println("[1] 21");
                System.out.println("[2] 5");
                System.out.println("[3] 104");
                System.out.println("[4] 1,625");
                if (scanner.nextInt() != 3) {
                    System.out.println("Das ist flasch! Probier es nocheinmal.");
                } else {
                    System.out.println("27 * 5 - 30 = ?");
                    System.out.println("[1] 135");
                    System.out.println("[2] 123");
                    System.out.println("[3] 105");
                    System.out.println("[4] 150");
                    if (scanner.nextInt() != 3) {
                        System.out.println("Rechne nochmal nach.");
                    } else {
                        player.intelligenz += 5;
                        System.out.println("Glückwunsch! Du bist schlauer geworden.");
                        matheaufgaben = false;
                    }
                }
            }
        }
    }
    void setFinanzbuero() {

    }
}
