package com.jambit;
public class TABuero extends Room {
    int position = 103;
    boolean urlaub1 = false;
    boolean urlaub2 = false;

    void execute( Player player){
        raumName = "TA Büro";
        spezial = "Urlaub machen";
        option(player, position);
        switch (auswahl){
            case 3:
                if (urlaub1 == false){
                    System.out.println("Du bist im Urlaub, warte einen Moment");
                    try{
                        Thread.sleep(10000);
                    }catch(InterruptedException e){}
                    System.out.println("Du hast dich erholt und bekommst dadurch eine bessere Gesundheit.");
                    player.gesundheit += 7;
                    urlaub1 = true;
                } else {
                    if (urlaub2 == false){
                        System.out.println("Du bist im Urlaub, warte einen Moment");
                        try{
                            Thread.sleep(10000);
                        }catch(InterruptedException e){}
                        System.out.println("Dies war dein letzter Urlaub. Du hast dich erholt und bekommst dadurch eine bessere Gesundheit.");
                        player.gesundheit += 7;
                        urlaub2 = true;
                    } else {
                        System.out.println("Du hast deinen Urlaub bereits verbraucht. Wähle eine andere Option");
                    }
                }
                break;
            case 4:
                player.position = 2;
                break;
        }
    }
    void setTABuero(){
    }
}