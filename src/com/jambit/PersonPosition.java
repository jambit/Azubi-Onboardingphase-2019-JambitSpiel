package com.jambit;

import java.util.LinkedHashMap;

public class PersonPosition extends Personen {
    public static LinkedHashMap<Personen, Integer> personPositionList = new LinkedHashMap<Personen, Integer>();
    public static Cherry cherry = new Cherry();
    public static Alma alma = new Alma();
    public static Finn finn = new Finn();
    public static Adalbert adalbert = new Adalbert();
    public static Marion marion = new Marion();


    void setPersons() {
        cherry.setCherry();

        alma.setAlma();

        finn.setFinn();

        adalbert.setAdalbert();

        marion.setMarion();

    }
    void setPersonPositionList(){
        personPositionList.put(cherry, cherry.position);
        personPositionList.put(alma, alma.position);
        personPositionList.put(finn, finn.position);
        personPositionList.put(adalbert, adalbert.position);
        personPositionList.put(marion,marion.position);
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
                break;
            case "Marion":
                marion.marionExecute();
                break;
        }
    }
}

