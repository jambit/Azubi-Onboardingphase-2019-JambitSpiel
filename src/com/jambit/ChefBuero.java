package com.jambit;

public class ChefBuero extends Room {
    int position = 108;

    void execute(Player player) {
        raumName = "Chef-Büro";
        spezial = "noch kein Special vorhanden";
        option(player, position);
        switch (auswahl) {
            case 3:
                break;
            case 4:
                break;
        }
    }

    void setChefBuero(){
        gegenstaende.put("Handy", 2);
    }

}
