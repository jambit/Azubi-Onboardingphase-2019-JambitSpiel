package com.jambit;

import javax.sound.midi.*;

public class Musik {
    public static void playAlleMeineEntchen()
            throws Exception {
        //Partitur {{Tonhoehe, DauerInViertelNoten, AnzahlWdh},...}
        final int DATA[][] = {
                {60, 1, 1}, //C
                {62, 1, 1}, //D
                {64, 1, 1}, //E
                {65, 1, 1}, //F
                {67, 2, 2}, //G,G
                {69, 1, 4}, //A,A,A,A
                {67, 4, 1}, //G
                {69, 1, 4}, //A,A,A,A
                {67, 4, 1}, //G
                {65, 1, 4}, //F,F,F,F
                {64, 2, 2}, //E,E
                {62, 1, 4}, //D,D,D,D
                {60, 4, 1}  //C
        };
        //Sequence bauen
        final int PPQS = 16;
        final int STAKKATO = 4;
        Sequence seq = new Sequence(Sequence.PPQ, PPQS);
        Track track = seq.createTrack();
        long currentTick = 0;
        ShortMessage msg;
        //Kanal 0 auf "EnsembleStrings" umschalten
        msg = new ShortMessage();
        msg.setMessage(ShortMessage.PROGRAM_CHANGE, 0, 48, 0);
        track.add(new MidiEvent(msg, currentTick));
        //Partiturdaten hinzufügen
        for (int i = 0; i < DATA.length; ++i) {
            for (int j = 0; j < DATA[i][2]; ++j) { //Anzahl Wdh. je Note
                msg = new ShortMessage();
                msg.setMessage(ShortMessage.NOTE_ON, 0, DATA[i][0], 64);
                track.add(new MidiEvent(msg, currentTick));
                currentTick += PPQS * DATA[i][1] - STAKKATO;
                msg = new ShortMessage();
                msg.setMessage(ShortMessage.NOTE_OFF, 0, DATA[i][0], 0);
                track.add(new MidiEvent(msg, currentTick));
                currentTick += STAKKATO;
            }
        }
        //Sequencer und Synthesizer initialisieren
        Sequencer sequencer = MidiSystem.getSequencer();
        Transmitter trans = sequencer.getTransmitter();
        Synthesizer synth = MidiSystem.getSynthesizer();
        Receiver rcvr = synth.getReceiver();
        //Beide öffnen und verbinden
        sequencer.open();
        synth.open();
        trans.setReceiver(rcvr);
        //Sequence abspielen
        sequencer.setSequence(seq);
        sequencer.setTempoInBPM(145);
        sequencer.start();
        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                //nothing
            }
            if (!sequencer.isRunning()) {
                break;
            }
        }
        //Sequencer anhalten und Geräte schließen
        sequencer.stop();
        sequencer.close();
        synth.close();
    }

    public static void main(String[] args) {
        try {
            playAlleMeineEntchen();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }
}