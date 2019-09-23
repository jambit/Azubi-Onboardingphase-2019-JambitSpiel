package com.jambit;

public class Main extends Player {
    public static Player player = new Player();
    public static Move move = new Move();
    public static PositionFinder positionFinder = new PositionFinder();
    public static PersonPosition personPosition = new PersonPosition();
    public static Gegenstand gegenstandListe = new Gegenstand();

    public static void main(String[] args) {


        //player.start();
        gegenstandListe.setGegenstand();
        personPosition.setPersons();
        positionFinder.setRoom();
        player.position = 1;
        while (checkLifeConditions(player)) {
            player.hunger += 2;
            if (player.position < 100) {
                move.moveScreen(player);
            }
            positionFinder.findPosition(player);
        }
    }

    static boolean checkLifeConditions(Player player) {
        if (player.gesundheit == 0 || player.hunger >= 60) {
            return false;
        }
        return true;
    }
}