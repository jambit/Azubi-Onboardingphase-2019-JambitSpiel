package com.jambit;

public class Marion extends Personen {
    void setMarion() {
        name = "Marion";
        gesundheit = 20;
        position = 108;
    }

    void marionExecute() {
        System.out.println("'Hi, wie geht es dir?'");
        int i = antworten3("Gut", "Passt schon", "Super! Ich bin total fröhlich.");
        switch (i){
            case 1:
                System.out.println("'Dass ist schön.'");
                break;
            case 2:
                System.out.println("'Ok'");
                break;
            case 3:
                System.out.println("'Dass freut mich.'");
                break;
        }
        System.out.println("'Kann ich etwas für dich tun?'");
        int j = antworten2("Ja, ich wollte meine Zugtickets vorbei bringen.", "Nein, ich wollte einfach mal vorbei schauen.");
        switch (j){
            case 1:
                System.out.println("'Ok, aber um sie zu bearbeiten brauche ich eine Maus.'");
                if (!Main.player.maus){
                    System.out.println("'Hol mir bitte Eine.'");
                } else{
                    System.out.println("'Ach du hast mir eine Mitgebracht. Vielen Dank.'");
                    Main.player.maus = false;
                    Main.player.intelligenz += 10;
                    System.out.println("Du hast Marion sehr geholfen. Dadurch ist deine Intelligenz auf " + Main.player.intelligenz + " gestiegen.");
                }
                break;
            case 2:
                System.out.println("'Oh, dass ist aber nett von dir. Jetzt muss ich aber leider weiter arbeiten.'");
                break;
        }
    }
}
