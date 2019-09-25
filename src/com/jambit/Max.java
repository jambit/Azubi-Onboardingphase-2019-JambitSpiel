package com.jambit;

public class Max extends Personen{
    void setMax() {
        name = "Max";
        gesundheit = 20;
        position = 105;
    }

    void maxExecute(){
        if (!Main.player.nasenspray){
            System.out.println("Max greift dich an. Was möchtest du tun?");
            int i = antworten2("Kämpfen", "Flüchten");
            switch (i){
                case 1:
                    Kampf kampf = new Kampf(name);
                    kampf.executeFight();
                    break;
                case 2:
                    System.out.println("Du bist geflohen.");
                    break;
            }
        } else {
            System.out.println("'Oh, du hast mein Nasenspray gefunden. Ich hab es schon überall gesucht. Kann ich es haben?'");
            int j = antworten2("Ja, hier bitte.", "Nein.");
            switch (j){
                case 1:
                    System.out.println("'Vielen Dank.'");
                    Main.player.nasenspray = false;
                    Main.player.intelligenz += 10;
                    Main.player.staerke += 10;
                    System.out.println("Du hast Max geholfen und Zain einen Gefallen getan. Dadurch haben sich deine Intelligenz zu " + Main.player.intelligenz + " erhöht und deine Stärke zu " + Main.player.staerke + " erhöht.");
                    break;
                case 2:
                    System.out.println("Max greift dich an.");
                    Kampf kampf = new Kampf(name);
                    kampf.executeFight();
                    break;
            }
        }
    }
}
