package com.jambit;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main extends Player {
    public static Player player = new Player();
    public static Move move = new Move();
    public static PositionFinder positionFinder = new PositionFinder();
    public static PersonPosition personPosition = new PersonPosition();
    public static Gegenstand gegenstandListe = new Gegenstand();
    public static boolean kampfinfo = true;

    public static void main(String[] args) throws Exception {
        player.start();

        gegenstandListe.setGegenstand();
        personPosition.setPersons();
        personPosition.setPersonPositionList();
        positionFinder.setRoom();
        player.position = 1;
        musikPlayer.starteAbspielen("audio/Soulstone.mp3");
        while (checkLifeConditions(player)) {
            player.hunger += 5;
            if (player.position < 100) {
                move.moveScreen(player);
            }
            positionFinder.findPosition(player);
        }

        Scanner scanner = new Scanner(System.in);

        musikPlayer.stop();
        System.out.println("\n" +
                "     )    )           (     (        (      \n" +
                "  ( /( ( /(           )\\ )  )\\ )     )\\ )   \n" +
                "  )\\()))\\())     (   (()/( (()/( (  (()/(   \n" +
                " ((_)\\((_)\\      )\\   /(_)) /(_)))\\  /(_))  \n" +
                "__ ((_) ((_)  _ ((_) (_))_ (_)) ((_)(_))_   \n" +
                "\\ \\ / // _ \\ | | | |  |   \\|_ _|| __||   \\  \n" +
                " \\ V /| (_) || |_| |  | |) || | | _| | |) | \n" +
                "  |_|  \\___/  \\___/   |___/|___||___||___/  \n" +
                "                                            \n");
        musikPlayer.starteAbspielen("audio/TheBigDecision.mp3");
        System.out.println("Drücke eine Taste um neu zu starten");

        while (!scanner.hasNext()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        scanner.nextLine();
        musikPlayer.stop();
        try {
            main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    static boolean checkLifeConditions(Player player) {
        if (player.gesundheit == 0 || player.hunger >= 100) {
            System.out.println("Du bist verhungert!!!");
            return false;
        }
        return true;
    }
}