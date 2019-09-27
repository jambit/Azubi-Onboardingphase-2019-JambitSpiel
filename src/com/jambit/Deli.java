

package com.jambit;

import java.util.Scanner;

public class Deli extends Room {
    Scanner raetsel = new Scanner(System.in);
    int position = 105;
    boolean ratsel = false;

    void execute(Player player) {
        raumName = "Deli";
        spezial = "Rätsel lösen";
        option(player, position);
        switch (auswahl) {
            case 3:
                if (ratsel == false) {
                    System.out.println("Ein Esel und Pferd ghen zu einer Mühle mit Säcken voll Getreide auf dem Rücken.");
                    System.out.println("Esel: Die Säcke sind voll schwer.");
                    System.out.println("Pferd: Hör auf dich zu beschweren, ich trage mehr als du.");
                    System.out.println("E.: Wenn du mir einen von deinen Säcken abgibst haben wir gleich viele.");
                    System.out.println("P.: Aber wenn du mir einen abgibst, habe ich doppelt so viele Säcke wie du.");
                    System.out.println();
                    System.out.println("Wie viele Säcke trägt das Pferd?");
                    int antwort1 = raetsel.nextInt();
                    System.out.println("Und wie viele Säcke trägt der Esel?");
                    int antwort2 = raetsel.nextInt();
                    if (antwort1 == 7 && antwort2 == 5) {
                        System.out.println("Glückwunsch! Du bist intelligenter geworden.");
                        player.intelligenz += 25;
                        ratsel = true;
                    } else {
                        System.out.println("Viel Glück beim nächsten Mal.");
                    }
                } else {
                    System.out.println("Hör auf bescheißen zu wollen. Du hast das Rätsel bereits gemacht und weißt die Antwort!");
                }
                break;
            case 4:
                player.position = 3;
                break;
        }
    }

    void setDeli() {
        gegenstaende.put("Ladekabel", 2);
        gegenstaende.put("Erdbeeren", 1);
    }
}

