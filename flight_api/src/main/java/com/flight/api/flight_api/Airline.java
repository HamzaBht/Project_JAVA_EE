package com.flight.api.flight_api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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

        //For Debug
        Aircraft aircraft = new Aircraft(600,600);
        AddAircraft(aircraft);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date time = new Date();
        Airport airport = new Airport("TNG", new City("Tanger"));
        DepartureArrivalInfo departureInfo = new DepartureArrivalInfo("Monday",format.format(time), airport);
        Flight flight = new Flight(FlightState.NO_TRACK_INFO,aircraft,departureInfo,departureInfo,1200);
        try {
            AddFlight(flight);
        } catch (AircraftNotExistingException e) {
            e.printStackTrace();
        }
    }

    //Maps each model to the aircraft object
    private ArrayList<Aircraft> aircrafts;

    //Map each flight number with corresponding flight
    private ArrayList<Flight> flights;

    public void AddFlight(Flight flight) throws AircraftNotExistingException {
        int aircraftID = flight.getAircraft().getID();
        if (aircraftID >= aircrafts.size()){
            throw new AircraftNotExistingException("Model :"+aircraftID+" not existing");
        }
        else {
            flight.setFlightNumber(flights.size());
            if (flight.getState() == null){
                flight.setState(FlightState.NO_TRACK_INFO);
            }
            flights.add(flight);
            //TODO: add flight to database
        }
    }

    public Collection<Flight> GetAllFlights(){
        return flights;
    }

    public void AddAircraft(Aircraft aircraft){
        aircraft.setID(aircrafts.size());
        aircrafts.add(aircraft);
    }
}