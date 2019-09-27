package com.jambit;

public class JambitMonster extends Personen {
    int anzahlBegegnungen;

    void setJambitMonster() {
        name = "JambitMonster";
        position = 101;
    }

    void jambitMonsterExecute() {
        if (anzahlBegegnungen == 0) {
            System.out.println("Servus, ich bin das Jambit Monster");
            System.out.println("Wir Glücksmonster sammeln uns immer an Orten, wo viele fröhliche Menschen sind!");
            System.out.println("Und hier haben wir so viel davon,");
            System.out.println("dass wir ganze Armeen füttern könnten!!!");
            System.out.println("Und wer bist du, dass du uns aufhalten könntest ?!?");
            int i = antworten2(Main.player.name + ",ein tapferer Jambitee, welcher für das Recht steht und dich herausfordern wird, koste es, was es wolle!!!", "öh, nö kein Bock auf nen Kampf");
            switch (i) {
                case 1:
                    Kampf kampf = new Kampf("JambitMonster");
                    kampf.executeFight();
                    Main.player.intelligenz += 12 ;
                    Main.player.staerke += 20;
                    position++;
                    break;
                case 2:
                    System.out.println("Tja, Pech gehabt, denn ich will");
                    Main.musikPlayer.stop();
                    Kampf kampf1 = new Kampf(name);
                    kampf1.executeFight();
                    System.out.println("Upgrade Statuswerte");
                    Main.player.intelligenz += 9;
                    Main.player.staerke += 20;
                    position++;
            }
        } else if (anzahlBegegnungen == 1) {
            System.out.println("Du schon wieder.");
            int i = antworten2("Jup", "Denkst du wirklich, ich würde dich so einfach laufen lassen?");
            switch (i) {
                case 1:
                    System.out.println("Tja, ich werde immer stärker, aber jetzt wird erstmal gekämpft!!!");
                    int j = antworten2("Kämpfen", "Fliehen");
                    switch (j) {
                        case 1:
                            Kampf kampf = new Kampf(name);
                            kampf.executeFight();
                            Main.player.intelligenz += 10;
                            Main.player.staerke += 15;
                            position++;
                            break;
                        case 2:
                            break;
                    }
                    break;
            }
        } else {
            System.out.println("Du schon wieder.");
            int j = antworten2("Kämpfen", "Fliehen");
            switch (j) {
                case 1:
                    Kampf kampf = new Kampf(name);
                    kampf.executeFight();
                    Main.player.intelligenz += 10;
                    Main.player.staerke += 20;
                    position++;
                    break;
                case 2:
                    break;
            }
        }
    }
}
