package com.jambit;

public class Finanzbuero extends Room {
    int position = 107;

    void execute(Player player){
        raumName = "Finanzbüro";
        spezial = "noch kein Special vorhanden";
        option(player, position);
        switch (auswahl) {
            case 3:
                break;
            case 4:
                player.position = 5;
                break;
        }
    }

    void setFinanzbuero(){

    }
}
