package com.jambit;

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
            player.hunger += 0;
            if (player.position < 100) {
                move.moveScreen(player);
            }
            positionFinder.findPosition(player);
        }

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
        musikPlayer.starteAbspielen("audio/Always Look on the Bright Side of Life.mp3");
    }

    static boolean checkLifeConditions(Player player) {
        if (player.gesundheit == 0 || player.hunger >= 100) {
            System.out.println("Du bist verhungert!!!");
            return false;
        }
        return true;
    }
}