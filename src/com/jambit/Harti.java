package com.jambit;

public class Harti extends Personen {

    void setHarti() {
        name = "Harti";
        position = 107;
    }

    void hartiExecute() {
        switch (Main.harti.position) {
            case 104:
                System.out.println("'Hier gibt es viel Cappuchino.'");
                break;
            case 107:
                System.out.println("'Hi, schön dich zu sehen. Allerdings brauche ich jetzt erstmal einen Cappuchino.'");
                if (Main.player.cappuccino) {
                    System.out.println("'Du hast mir Einen mitgebracht? Vielen Dank. Du weißt, dass uns bei Jambit Feedback wichtig ist. Also, wie gefällt es dir hier?'");
                    int j = antworten3("Super", "Gut", "Nicht so.");
                    switch (j) {
                        case 1:
                            System.out.println("'Das freut mich. Ich muss jetzt los, damit ich mit meinem Fahrrad noch rechtzeitig nach Hause komme.'");
                            break;
                        case 2:
                            System.out.println("'Ok, wenn du irgendwelche Verbesserungs.Vorschläge hast, dann kannst sie gerne mit mir oder jemand anderem besprechen. Jetzt muss ich allerdings los damit ich noch rechtzeitig mit meinem Fahrrad nach Hause komme.'");
                            break;
                        case 3:
                            System.out.println("'Das ist schade, aber warum sagst du denn nichts? Es ist doch wichtig, dass wir das wissen, damit wir etwas verbessern können. Ich muss jetzt leider los, aber wir können gerne einen Termin ausmachen und dann können wir darüber reden'");
                            break;
                    }
                } else {
                    System.out.println("'Vielleicht sieht man sich ja nochmal.'");
                    Main.harti.position = 104;
                    Main.personPosition.setPersonPositionList();
                }
                break;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
