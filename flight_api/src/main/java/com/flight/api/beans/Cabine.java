package com.flight.api.beans;

import javax.json.bind.annotation.JsonbTransient;

public class Cabine {
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    @JsonbTransient
    private int ID;
    private String type;
    private int capacity;
    private int availablePlaces;

    public Cabine(String type, int capacity, int availablePlaces) {
        this.type = type;
        this.capacity = capacity;
        this.availablePlaces = availablePlaces;
    }

    public String getType() {
        return type;
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
