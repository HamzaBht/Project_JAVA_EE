package com.flight.api.flight_api;

import java.util.Collection;
import java.util.HashMap;

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
        aircrafts = new HashMap<>();
        flights = new HashMap<>();
        flightCount = new Integer(0);
        //TODO: Load flights and aircrafts from database

        //For Debug Purpose
        Aircraft aircraftTst = new Aircraft("Boeing-747",600);
        AddAircraft(aircraftTst);
        DepartureArrivalInfo departureTst = new DepartureArrivalInfo();
        DepartureArrivalInfo arrivalTst = new DepartureArrivalInfo();
        Flight flightTst = new Flight(0,FlightState.NO_TRACK_INFO, aircraftTst,departureTst, arrivalTst,1200.f);
        try {
            AddFlight(flightTst);
        } catch (ModelNotExistingException e) {
            e.printStackTrace();
        }
    }

    //Maps each model to the aircraft object
    private HashMap<String, Aircraft> aircrafts;

    //Map each flight number with corresponding flight
    private HashMap<Integer, Flight> flights;

    static Integer flightCount;

    public void AddFlight(Flight flight) throws ModelNotExistingException{
        String aircraftModel = flight.getAircraft().getModel();
        if (!aircrafts.containsKey(aircraftModel)){
            throw new ModelNotExistingException("Model :"+aircraftModel+" not existing");
        }
        else {
            flight.setFlightNumber(flightCount);
            if (flight.getState() == null){
                flight.setState(FlightState.NO_TRACK_INFO);
            }
            flights.put(flightCount, flight);
            flightCount++;
            //TODO: add flight to database
        }
    }

    public Collection<Flight> GetAllFlights(){
        return flights.values();
    }

    public void AddAircraft(Aircraft aircraft){
        aircrafts.put(aircraft.getModel(), aircraft);
    }
}