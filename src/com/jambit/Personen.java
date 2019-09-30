
package com.jambit;

import java.util.HashMap;
import java.util.Scanner;

public class Personen {
    int position;
    String name;
    int gesundheit;
    boolean lebend = true;
    public static String antwortEins;
    public static String antwortZwei;
    public static String antwortDrei;
    public static String antwortVier;
    private static int auswahl;
    public static Scanner scanner = new Scanner(System.in);

    int antworten(String antwortEins, String antwortZwei, String antwortDrei, String antwortVier) {
        System.out.println("[1] " + antwortEins);
        System.out.println("[2] " + antwortZwei);
        System.out.println("[3] " + antwortDrei);
        System.out.println("[4] " + antwortVier);
        auswahl = scanner.nextInt();
        return auswahl;
    }

    int antworten3(String antwortEins, String antwortZwei, String antwortDrei) {
        System.out.println("[1] " + antwortEins);
        System.out.println("[2] " + antwortZwei);
        System.out.println("[3] " + antwortDrei);
        auswahl = scanner.nextInt();
        return auswahl;
    }

    int antworten2(String antwortEins, String antwortZwei) {
        System.out.println("[1] " + antwortEins);
        System.out.println("[2] " + antwortZwei);
        auswahl = scanner.nextInt();
        return auswahl;
    }
}

