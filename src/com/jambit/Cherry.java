
package com.jambit;

public class Cherry extends Personen {
    void setCherry() {
        name = "Cherry";
        gesundheit = 20;
        position = 101;
    }

    void cherryExecute(Cherry cherry) {
        System.out.println("'Hast du dein Berichtsheft schon fertig gemacht?'");
        int i = antworten2("Ja", "Nein");
        switch (i) {
            case 1:
                System.out.println("'Das ist schön. Gib es mir bitte noch ab.'");
                break;
            case 2:
                System.out.println("Cherry ist sauer geworden und greift dich an. Was möchtest du tun? Bedenke, dass Cherry sehr stark ist.");
                int j = antworten2("Flüchten", "Kämpfen");
                switch (j) {
                    case 1:
                        break;
                    case 2:
                        Kampf kampf = new Kampf(name);
                        kampf.executeFight();
                        break;
                }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        cherry.position = 105;
        Main.personPosition.setPersonPositionList();
    }
}

