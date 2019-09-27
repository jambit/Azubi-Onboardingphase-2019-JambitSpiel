package com.jambit;

public class Besucher extends Personen {
    void setBesucher() {
        name = "Besucher";
        gesundheit = 20;
        position = 106;
    }

    void besucherExecute(Besucher besucher) {
        System.out.println("Du stellst fest, dass der Besucher kein Badge hat. Was machst du?");
        int i = antworten2("ihn darauf ansprechen", "es ignorieren");
        switch (i){
            case 1:
                System.out.println("Der Besucher kann immer noch kein Badge vorweisen und du möchtest ihn zum Empfang begleiten, doch er weigert sich. Was tust du?");
                int j = antworten2("mit ihm kämpfen", "ihn in Ruhe lassen");
                switch (j){
                    case 1:
                        Kampf kampf = new Kampf(name);
                        kampf.executeFight();
                        besucher.position = 102;
                        Main.personPosition.setPersonPositionList();
                        break;
                    case 2:
                        System.out.println("Du hast die falsche Entscheidung getroffen. Du hast 50 Intelligenz verloren.");
                        Main.player.intelligenz -= 50;
                        break;
                }
                break;
            case 2:
                System.out.println("Du solltest es nicht ignorieren, wenn jemand kein Badge trägt. Du hast 50 Intelligenz verloren.");
                Main.player.intelligenz -= 50;
                break;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        Main.player.position = 300;
    }
}
