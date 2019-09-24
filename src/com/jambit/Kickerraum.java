package com.jambit;

public class Kickerraum extends Room {
    int position=202;

    void execute(Player player) {
        raumName = "Kickerraum";
        spezial = "kickern";
        option(player, position);
        switch (auswahl) {
            case 3:
                break;
            case 4:
                player.position = 5;
                break;
        }
    }

    void setKickerraum(){

    }
}
