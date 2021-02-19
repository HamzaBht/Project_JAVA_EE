package com.flight.api.flight_api;

public class Aircraft {
    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public Aircraft(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    private String model;
    private int capacity;
}
