package com.jambit;

public class Helpdesk extends Room {
    int position = 201;

    void execute(Player player) {
        raumName = "Helpdesk";
        spezial = "Support";
        option(player, position);
        switch (auswahl) {
            case 3:
                support(player);
                break;
            case 4:
                player.position = 5;
                System.out.println("Du befindest dich wieder im 3. Stockwerk.");
                break;
        }
    }

    void setHelpdesk() {
        gegenstaende.put("Spezi", 3);
    }

    void support(Player player) {
        System.out.println("Brauchst du Hilfe?");
        System.out.println("[1] Ja");
        System.out.println("[2] Nein");
        auswahl = scanner.nextInt();
        switch (auswahl) {
            case 1:
                System.out.println("Was für eine Art Hilfe brauchst du?");
                System.out.println("[1] First-Level-Support");
                System.out.println("[2] Second-Level-Support");
                System.out.println("[3] Third-Level-Support");
                System.out.println("[4] doch keinen");
                auswahl = scanner.nextInt();

                switch (auswahl) {
                    case 1:
                        System.out.println("UND? Wirds noch genauer?");
                        System.out.println("[1] Ich hätte gern ein Ladekabel für mein Laptop");
                        System.out.println("[2] Ich hätte gern einen Stift");
                        auswahl = scanner.nextInt();

                        switch (auswahl) {
                            case 1:
                                System.out.println("Hast du einen Laptop?");

                                System.out.println("[1] Ja, klar");
                                System.out.println("[2] Nein, ich muss meinen erst holen");
                                auswahl = scanner.nextInt();

                                switch (auswahl) {
                                    case 1:
                                        if (player.inventory.containsKey("Laptop")) {
                                            System.out.println("Hier, ein Ladekabel und noch ein Ersatzkabel");
                                            System.out.println("Du bist schlauer geworden");
                                            player.intelligenz += 18;
                                            player.inventory.put("Ladekabel", 2);
                                        } else {
                                            System.out.println("Du hast keinen Laptop in deinem Inventar, hol dir einen.");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("OK");
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Nö, hols dir wo anders");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Erstell ein Ticket.");
                        break;
                    case 3:
                        System.out.println("Mach ein Ticket auf.");
                        break;
                    case 4:
                        System.out.println("OK");
                        break;
                }
                break;
            case 2:
                System.out.println("OK");
                break;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
