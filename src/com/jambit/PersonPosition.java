package com.jambit;

import java.util.LinkedHashMap;

public class PersonPosition extends Personen {

    public static LinkedHashMap<Personen, Integer> personPositionList = new LinkedHashMap<Personen, Integer>();
    public static Cherry cherry = new Cherry();
    public static Alma alma = new Alma();
    public static Finn finn = new Finn();
    public static Adalbert adalbert = new Adalbert();
    public static Marion marion = new Marion();
    public static Besucher besucher = new Besucher();
    public static JambitMonster jambitMonster = new JambitMonster();
    public static Zain zain = new Zain();
    public static Max max = new Max();
    public static Harti harti = new Harti();
    public static Felli felli = new Felli();
    public static AudiTyp audiTyp = new AudiTyp();


    void setPersons() {
        cherry.setCherry();
        alma.setAlma();
        finn.setFinn();
        adalbert.setAdalbert();
        marion.setMarion();
        besucher.setBesucher();
        jambitMonster.setJambitMonster();
        zain.setZain();
        max.setMax();
        harti.setHarti();
        felli.setFelli();
        audiTyp.setAudiTyp();
    }

    void setPersonPositionList() {
        personPositionList.put(cherry, cherry.position);
        personPositionList.put(alma, alma.position);
        personPositionList.put(finn, finn.position);
        personPositionList.put(adalbert, adalbert.position);
        personPositionList.put(marion, marion.position);
        personPositionList.put(besucher, besucher.position);
        personPositionList.put(jambitMonster, jambitMonster.position);
        personPositionList.put(zain, zain.position);
        personPositionList.put(max, max.position);
        personPositionList.put(harti, harti.position);
        personPositionList.put(felli, felli.position);
        personPositionList.put(audiTyp, audiTyp.position);
    }

    void triggerPerson(String x) {
        switch (x) {
            case "Cherry":
                if (cherry.lebend) {
                    cherry.cherryExecute(cherry);
                } else System.out.println("Sorrry, die Person ist leider Tod...");
                break;
            case "Alma":
                if (alma.lebend) {
                    alma.almaExecute(alma);
                } else System.out.println("Sorrry, die Person ist leider Tod...");
                break;
            case "Finn":
                if (finn.lebend) {
                    finn.finnExecute(finn);
                } else System.out.println("Sorrry, die Person ist leider Tod...");
                break;
            case "Adalbert":
                if (adalbert.lebend) {
                    adalbert.adalbertExecute();
                } else System.out.println("Sorrry, die Person ist leider Tod...");
                break;
            case "Marion":
                if (marion.lebend) {
                    marion.marionExecute();
                } else System.out.println("Sorrry, die Person ist leider Tod...");
                break;
            case "Besucher":
                if (besucher.lebend) {
                    besucher.besucherExecute(besucher);
                } else System.out.println("Sorrry, die Person ist leider Tod...");
                break;
            case "JambitMonster":
                jambitMonster.jambitMonsterExecute();
                break;
            case "Zain":
                zain.zainExecute();
                break;
            case "Max":
                max.maxExecute();
                break;
            case "Harti":
                harti.hartiExecute();
                break;
            case "Felli":
                felli.felliExecute();
                break;
            case "Audi-Typ":
                audiTyp.audiTypExecute();
                break;
        }
    }
}
