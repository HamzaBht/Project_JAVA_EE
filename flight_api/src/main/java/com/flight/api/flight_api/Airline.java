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
        aircrafts = new ArrayList<>();
        flights = new ArrayList<>();
        //TODO: Load flights and aircrafts from database
    }

    //Maps each model to the aircraft object
    private ArrayList<Aircraft> aircrafts;

    //Map each flight number with corresponding flight
    private ArrayList<Flight> flights;

    public Collection<Flight> GetAllFlights(){
        return flights;
    }
}