package com.jambit;

import java.util.Scanner;

public class Java extends Room{
    int position = 104;
    Scanner kaffemaschine = new Scanner (System.in);

    void execute( Player player){
        spezial = "Kaffeemaschine";
        raumName = "Java";
        option(player, position);
        switch (auswahl){
            case 3:
                System.out.println("Was möchtest du machen?");
                System.out.println("[1] Kaffe");
                System.out.println("[2] Cappuchino");
                int maschine = kaffemaschine.nextInt();
                switch (maschine){
                    case 1:
                        gegenstaende.put("Kaffee",1);
                        System.out.println("Du hast einen Kaffe gemacht.");
                        break;
                    case 2:
                        Main.player.cappuccino = true;
                        System.out.println("Du hast einen Cappuchino gemacht.");
                        break;
                }
                break;
            case 4:
                player.position = 3;
                break;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    void setJava(){
        gegenstaende.put("Kuchen", 2);
    }
}
