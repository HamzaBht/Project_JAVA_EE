package com.example.Comparateur.beans;


public class Cabine {
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;
    private String type;
    private int capacity;
    private int availablePlaces;


    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Cabine{" +
                "ID=" + ID +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", availablePlaces=" + availablePlaces +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(int availablePlaces) {
        this.availablePlaces = availablePlaces;
    }
}
