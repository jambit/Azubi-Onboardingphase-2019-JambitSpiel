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
                player.position = 4;
                break;
        }
    }

    void setHelpdesk(){

    }
}
