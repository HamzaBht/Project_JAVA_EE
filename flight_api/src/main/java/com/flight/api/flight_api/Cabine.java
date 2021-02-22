package com.flight.api.flight_api;

public class Cabine {
    private CabineClasses type;
    private int capacity;
    private int availablePlaces;

    public Cabine(CabineClasses type, int capacity, int availablePlaces) {
        this.type = type;
        this.capacity = capacity;
        this.availablePlaces = availablePlaces;
    }

    public CabineClasses getType() {
        return type;
    }

    public void setType(CabineClasses type) {
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
