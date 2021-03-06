package com.fligght.beans;


public class Cabine {
    private CabineClass type;
    private int capacity;
    private int availablePlaces;

    public CabineClass getType() {
        return type;
    }

    public void setType(CabineClass type) {
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
