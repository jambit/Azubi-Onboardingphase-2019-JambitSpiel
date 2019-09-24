package com.jambit;


public class ThreadForMusic extends Thread {
    Musik musik = new Musik();
    @Override
   public void run() {
        try {
            musik.playAlleMeineEntchen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

