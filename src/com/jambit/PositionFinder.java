package com.jambit;

public class PositionFinder extends PersonPosition {
    public static Sumatra sumatra = new Sumatra();
    public static Empfang empfang = new Empfang();
    public static TABuero taBuero = new TABuero();
    public static Java java = new Java();
    public static Kalimantan kalimantan = new Kalimantan();
    public static Deli deli = new Deli();
    public static Helpdesk helpdesk = new Helpdesk();
    public static Kickerraum kickerraum = new Kickerraum();
    public static Finanzbuero finanzbuero = new Finanzbuero();

     static void setRoom() {
        empfang.setEmpfang();
        sumatra.setSumatra();
        taBuero.setTABuero();
        java.setJava();
        deli.setDeli();
        helpdesk.setHelpdesk();
        kickerraum.setKickerraum();
        finanzbuero.setFinanzbuero();
    }

    void findPosition(Player player) {
        switch (player.position) {
            case 101:
                sumatra.execute(player);
                break;
            case 102:
                empfang.execute(player);
                break;
            case 103:
                taBuero.execute(player);
                break;
            case 104:
                java.execute(player);
                break;
            case 105:
                deli.execute(player);
                break;
            case 106:
                kalimantan.execute(player);
                break;
            case 107:
                finanzbuero.execute(player);
                break;
            case 201:
                helpdesk.execute(player);
                break;
            case 202:
                kickerraum.execute(player);
                break;
        }
    }
}