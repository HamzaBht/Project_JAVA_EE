package com.flight.api.flight_api;

public class AircraftNotExistingException extends Exception{
    public AircraftNotExistingException(String s) {
        super(s);
    }
}
