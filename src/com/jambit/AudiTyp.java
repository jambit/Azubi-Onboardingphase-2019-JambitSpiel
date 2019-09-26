package com.jambit;

public class AudiTyp extends Personen {

    void setAudiTyp() {
        name = "Audi-Typ";
        position = 108;
    }

    void audiTypExecute() {
        System.out.println("Audi-Typ (am Handy): Hi, ich bin's wie gehts?");
        System.out.println("...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("A-T (am Handy): Ja klar, das kann ich verstehen.");
        System.out.println("...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("A-T (am Handy): Natürlich hab ich daran gedacht.");
        System.out.println("...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("A-T (am Handy): Ok, ich glaub ich muss aufhören. Hier steht jemand im Raum und schaut mich komisch an.");
        System.out.println("...");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
        }
        System.out.println("A-T (am Handy): Tschüss, bis heute Abend.");
        System.out.println("A-T (zu dir): Was stehst du da und beobachtest mich beim telefonieren?");
        int i = antworten3("Ach, ich war nur überrascht, dass du einfach in dem Büro der Chefs telefonierst.", "Du weißt schon das, dass hier das Büro der Chefs ist.", "Tut mir leid ich bin schon weg.");
        switch (i){
            case 1:
            case 2:
                System.out.println("A-T: Das ist das Büro der Chefs? Ups, das wusste ich nicht.");
                int j = antworten2("Was dachtest du denn, warum die hier rumstehen?", "Naja, jetzt weißt du es ja.");
                switch (j){
                    case 1:
                        System.out.println("A-T: Ich dachte hier wäre ein Meetingraum. Aber jetzt weiß ich es besser. Ich bin dann mal weg.");
                        break;
                    case 2:
                        System.out.println("A-T: Stimmt. Ich gehe dann mal.");
                        break;
                }
                break;
            case 3:
                System.out.println("A-T: Ja ist besser.");
                break;
        }
        Main.audiTyp.position = 300;
    }
}
