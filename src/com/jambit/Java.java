package com.jambit;

public class Java extends Room{
    int position = 104;

    void execute( Player player){
        spezial = "Kaffee machen";
        raumName = "Java";
        option(player, position);
        switch (auswahl){
            case 3:
                gegenstaende.put("Kaffee",1);
                break;
            case 4:
                player.position = 3;
                break;
        }
    }
    void setJava(){
        gegenstaende.put("Kuchen", 2);
    }
}
