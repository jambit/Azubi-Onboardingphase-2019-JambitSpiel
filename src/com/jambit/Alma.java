
package com.jambit;

public class Alma extends Personen {
    void setAlma() {
        name = "Alma";
        gesundheit = 20;
        position = 103;
    }

    void almaExecute(Alma alma) {
        System.out.println("'Was machst du die ganze Zeit?'");
        int i = antworten("schlafen", "Kaffe trinken", "kickern", "arbeiten");
        switch (i) {
            case 1:
                System.out.println("'Du hast also im Gegensatz zu mir nichts zu tun.'");
                break;
            case 2:
                System.out.println("'Ich hoffe er schmeckt.'");
                break;
            case 3:
                System.out.println("'Das macht sicher Spaß.'");
                break;
            case 4:
                System.out.println("'Ja wer nicht?'");
                break;
        }
        System.out.println("'Was willst du hier?'");
        int j = antworten3("dich besuchen", "Schüsselkarte suchen", "mir ist langweilig");
        switch (j) {
            case 1:
                System.out.println("'Das ist nett von dir. Allerdings muss ich jetzt weiter arbeiten.'");
                break;
            case 2:
                System.out.println("'Ich habe eine, aber ich gebe sie dir nur über meine Leiche.'");
                Kampf kampf = new Kampf(name);
                kampf.executeFight();
                System.out.println("Du hast Alma besiegt und von ihr eine Schlüsselkarte gestohlen.");
                Main.player.badge2 = true;
                break;
            case 3:
                System.out.println("'Wenn du nichts anderes zu tun hast, dann geh doch kickern.'");
                break;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        alma.position = 104;
        Main.personPosition.setPersonPositionList();
    }
}

