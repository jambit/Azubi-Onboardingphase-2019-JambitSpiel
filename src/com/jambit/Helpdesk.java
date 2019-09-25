package com.jambit;

public class Helpdesk extends Room{
    int position=201;

    void execute(Player player) {
        raumName = "Helpdesk";
        spezial = "noch kein Special vorhanden";
        option(player, position);
        switch (auswahl) {
            case 3:
                break;
            case 4:
                player.position = 5;
                System.out.println("Du befindest dich wieder im 3. Stockwerk.");
                break;
        }
    }

    void setHelpdesk(){
        gegenstaende.put("Spezi", 1);
    }
}
