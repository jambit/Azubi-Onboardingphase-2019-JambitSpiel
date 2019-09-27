package com.jambit;

public class Adalbert extends Personen {

    void setAdalbert() {
        name = "Adalbert";
        gesundheit = 20;
        position = 201;
    }

    void adalbertExecute() {
        System.out.println("'Hi, möchtest du etwas bestimmtes?'");
        int i = antworten2("ja", "nein");
        switch (i){
            case 1:
                System.out.println("Was möchtest du denn?");
                int j = antworten3("Ich wollte dir nur ein Spezi vorbei bringen", "Hast du Lust kickern zu gehen?", "Ich brauche eine Maus.");
                switch (j){
                    case 1:
                        System.out.println("'Das ist aber nett von dir.'");
                        break;
                    case 2:
                        System.out.println("'Natürlich, ich muss aber leider arebiten.'");
                        break;
                    case 3:
                        if (!Main.player.maus) {
                            System.out.println("'Hier hast du eine.'");
                            Main.player.maus = true;
                        }
                        else
                            System.out.println("'Ich hab dir schon eine gegeben.'");
                        break;
                }
                break;
            case 2:
                System.out.println("'Was störst du mich dann?'");
                break;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
