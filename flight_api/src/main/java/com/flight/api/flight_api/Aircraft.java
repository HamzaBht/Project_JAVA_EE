package com.flight.api.flight_api;


import java.util.ArrayList;

public class Aircraft {
    private int ID;
    private ArrayList<Cabine> cabines;

    public Aircraft(int ID, ArrayList<Cabine> cabines) {
        this.ID = ID;
        this.cabines = cabines;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Cabine> getCabines() {
        return cabines;
    }

    public void setCabines(ArrayList<Cabine> cabines) {
        this.cabines = cabines;
    }
}
