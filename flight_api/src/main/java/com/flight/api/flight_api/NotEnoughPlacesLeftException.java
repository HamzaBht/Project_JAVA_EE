package com.flight.api.flight_api;

public class NotEnoughPlacesLeftException extends Exception{
    public NotEnoughPlacesLeftException(String s) {
        super(s);
    }
}
