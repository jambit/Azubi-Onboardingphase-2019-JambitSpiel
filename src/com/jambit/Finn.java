package com.jambit;

public class Finn extends Personen {
    void setFinn() {
        name = "Finn";
        gesundheit = 20;
        position = 105;
    }

    void finnExecute() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Wie geht's?");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}


