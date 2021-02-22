package com.flight.api.flight_api;

public class Flight {
    public Flight( FlightState state,
                  Aircraft aircraft,
                  DepartureArrivalInfo departureInfo,
                  DepartureArrivalInfo arrivalInfo,
                   float price)
    {
        this(0,state,aircraft,departureInfo,arrivalInfo,price);
    }

    public Flight(int flightNumber, FlightState state, Aircraft aircraft, DepartureArrivalInfo departureInfo, DepartureArrivalInfo arrivalInfo, float price) {
        this.flightNumber = flightNumber;
        this.state = state;
        this.aircraft = aircraft;
        this.departureInfo = departureInfo;
        this.arrivalInfo = arrivalInfo;
        this.price = price;
    }

    public int getFlightNumber() {
        return flightNumber;
    }
    public FlightState getState() {
        return state;
    }
    public Aircraft getAircraft() {
        return aircraft;
    }
    public DepartureArrivalInfo getDepartureInfo() {
        return departureInfo;
    }
    public DepartureArrivalInfo getArrivalInfo() {
        return arrivalInfo;
    }
    public float getPrice() {
        return price;
    }
    public void setState(FlightState state) {
        this.state = state;
    }
    public void setDepartureInfo(DepartureArrivalInfo departureInfo) {
        this.departureInfo = departureInfo;
    }
    public void setArrivalInfo(DepartureArrivalInfo arrivalInfo) {
        this.arrivalInfo = arrivalInfo;
    }
    public void setPrice(float price) {
        if (price >= 0.0f) {
            this.price = price;
        }
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    private int flightNumber;

    private FlightState state;
    private Aircraft aircraft;

    private DepartureArrivalInfo departureInfo;
    private DepartureArrivalInfo arrivalInfo;
    private float price;
}
