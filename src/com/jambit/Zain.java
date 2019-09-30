package com.jambit;

public class Zain extends Personen {
    void setZain() {
        name = "Zain";
        gesundheit = 20;
        position = 101;
    }

    void zainExecute() {
        System.out.println("'Hi, schön dich zu sehen. Hast du kurz Zeit mir einen Gefallen zu tun?'");
        int i = antworten2("Natürlich.", "Nein tut mir leid.");
        switch (i) {
            case 1:
                System.out.println("'Max hat sein Nasenspray hier verloren, aber er müsste noch irgenwo hier rumlaufen. Ich hab allerdings keine Zeit es ihm zu bringen. Könntest du das für mich machen? Ich bin sicher er freut sich und du bekommst eine Belohnung.'");
                int j = antworten2("Ja, ich mache das. Kein Problem.", "Nein ich hab keine Lust.");
                switch (j) {
                    case 1:
                        System.out.println("'Danke.'");
                        if (!Main.player.nasenspray) {
                            Main.player.nasenspray = true;
                            break;
                        }
                    case 2:
                        System.out.println("'Dann muss er wohl ohne auskommen.'");
                        break;
                }
                break;
            case 2:
                System.out.println("'Ok, schade'");
                break;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
