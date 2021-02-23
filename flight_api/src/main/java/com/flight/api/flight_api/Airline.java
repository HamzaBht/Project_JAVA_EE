package com.flight.api.flight_api;

import java.util.ArrayList;
import java.util.Collection;

//Singleton class
public class Airline {
    static private Airline ourAirline;
    static public Airline getInstance(){
        if (ourAirline == null){
            ourAirline = new Airline();
        }
        return ourAirline;
    }
    private Airline() {
        flights = new ArrayList<>();
    }

    private ArrayList<Flight> flights;

    public Collection<Flight> GetAllFlights(){
        return flights;
    }
}