package com.jambit;

public class Main extends Player {
    public static Player player = new Player();
    public static Move move = new Move();
    public static PositionFinder positionFinder = new PositionFinder();
    public static PersonPosition personPosition = new PersonPosition();
    public static Gegenstand gegenstandListe = new Gegenstand();
    public static boolean kampfinfo = true;


    public static void main(String[] args) throws Exception {

        //player.start();

        gegenstandListe.setGegenstand();
        personPosition.setPersons();
        positionFinder.setRoom();
        player.position = 1;
        while (checkLifeConditions(player)) {
            player.hunger += 0;
            if (player.position < 100) {
                move.moveScreen(player);
            }
            positionFinder.findPosition(player);
        }
        System.out.println("You Died");
        musikPlayer.starteAbspielen("audio/Always Look on the Bright Side of Life.mp3");
    }

    static boolean checkLifeConditions(Player player) {
        if (player.gesundheit == 0 || player.hunger >= 100) {
            System.out.println("Verhungert oder hast kein Leben mehr");
            return false;
        }
        return true;
    }
}