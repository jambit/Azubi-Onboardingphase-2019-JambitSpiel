package com.jambit;

public class Felli extends Personen {

    void setFelli() {
        name = "Felli";
        position = 107;
    }

    void felliExecute() {
        if (Main.player.zwischenSpeicher.equals("nein")) {
            System.out.println("'Hi, ich hab dich noch nie bei Kick-it like jambit gesehen. Warum machst du nicht mit?'");
            int i = antworten3("Ich mag Fußball nicht.", "Ich mache nicht so gerne Sport.", "Ich bin noch nicht dazu gekommen mitzuspielen, aber ich hatte es vor.");
            switch (i) {
                case 1:
                case 2:
                    System.out.println("'Du hast es doch noch gar nicht probiert. Gib uns doch eine Chance dich zu überzeugen. Es macht echt Spaß.'");
                    int j = antworten3("Nein, danke. Ich bin wirklich kein Fußball-Fan, aber euch viel Spaß.", "Ok, ich komme mal vorbei und schaue zu.", "Na gut, überredet. Ich bin am Freitag mit dabei und probier es mal aus.");
                    switch (j) {
                        case 1:
                            System.out.println("'Na gut. Ich kann dich auch schlecht zwingen. Aber schau dir doch mal die anderen Freizeitgruppen an. Es gibt bestimmt etwas, dass auch dir Spaß macht.'");
                            System.out.println("'Jetzt muss ich weiter arbeiten. Vielleicht sieht man sich irgendwann doch noch beim Fußball spielen.'");
                            break;
                        case 2:
                            System.out.println("'Ok, ich hab nicht ganz das erreicht was ich wollte, aber immmerhin etwas.'");
                            System.out.println("'Aber jetzt muss ich weiter arbeiten. Bis Freitag. Ich bin mir sicher wir schaffen es dich zu überzeugen.'");
                            break;
                        case 3:
                            System.out.println("'Super, dass freut mich. Du wirst deine Entscheidung nicht bereuen.'");
                            System.out.println("'Ich muss jetzt weiter arbeiten. Bis Freitag.'");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("'Ich hoffe du schaffst es möglichst bald. Es macht echt viel Spaß?'");
                    break;
            }
        } else if (Main.player.zwischenSpeicher.equals("ja")) {
            System.out.println("'Hi, und? Wie gefäällt es dir bei Kick-it like jambit'");
            int k = antworten2("Total gut.", "Gut, es macht echt Spaß.");
            switch (k) {
                case 1:
                    System.out.println("'Das freut mich. Dann sehen wir uns am Freitag?'");
                    break;
                case 2:
                    System.out.println("'Super, dass freut mich. '");
                    break;
            }
        }
    }
}
