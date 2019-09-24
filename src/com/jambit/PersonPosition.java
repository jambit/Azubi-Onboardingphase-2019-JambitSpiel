package com.jambit;

import java.util.LinkedHashMap;

public class PersonPosition extends Personen {
    public static LinkedHashMap<Personen, Integer> personPositionList = new LinkedHashMap<Personen, Integer>();
    public static Cherry cherry = new Cherry();
    public static Alma alma = new Alma();
    public static Finn finn = new Finn();
    public static Adalbert adalbert = new Adalbert();


    void setPersons() {
        cherry.setCherry();
        personPositionList.put(cherry, cherry.position);
        alma.setAlma();
        personPositionList.put(alma, alma.position);
        finn.setFinn();
        personPositionList.put(finn, finn.position);
        adalbert.setAdalbert();
        personPositionList.put(adalbert, adalbert.position);
    }

    void triggerPerson(String x) {
        switch (x) {
            case "Cherry":
                cherry.cherryExecute();
                break;
            case "Alma":
                alma.almaExecute();
                break;
            case "Finn":
                finn.finnExecute();
                break;
            case "Adalbert":
                adalbert.adalbertExecute();
        }
    }
}

