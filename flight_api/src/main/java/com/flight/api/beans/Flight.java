package com.flight.api.beans;

import com.flight.dao.DAOException;
import com.flight.dao.implementations.DAOFactory;

public class Flight {

    public Flight(int flightNumber, Cabine cabine, DepartureArrivalInfo departureInfo, DepartureArrivalInfo arrivalInfo, Double price) {
        this.flightNumber = flightNumber;
        this.cabine = cabine;
        this.departureInfo = departureInfo;
        this.arrivalInfo = arrivalInfo;
        this.price = price;
    }

    public int getFlightNumber() {
        return flightNumber;
    }
    public DepartureArrivalInfo getDepartureInfo() {
        return departureInfo;
    }
    public DepartureArrivalInfo getArrivalInfo() {
        return arrivalInfo;
    }
    public Double getPrice() {
        return price;
    }
    public void setDepartureInfo(DepartureArrivalInfo departureInfo) {
        this.departureInfo = departureInfo;
    }
    public void setArrivalInfo(DepartureArrivalInfo arrivalInfo) {
        this.arrivalInfo = arrivalInfo;
    }
    public void setPrice(Double price) {
        if (price >= 0.0f) {
            this.price = price;
        }
    }

    public Cabine getCabine() {
        return cabine;
    }

    public void setCabine(Cabine cabine) {
        this.cabine = cabine;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    private int flightNumber;

    private Cabine cabine;

    private DepartureArrivalInfo departureInfo;
    private DepartureArrivalInfo arrivalInfo;
    private Double price;
    private boolean available = false;

    public boolean OpenReservation(){
        if (!available){
            available = true;
            try {
                DAOFactory.getInstance().getFlightDAO().Update(this);
            }
            catch (DAOException e){
                available = false;
                return false;
            }
        }
        return true;
    }
    public boolean CloseReservation(){
        if (available){
            available = false;
            try{
                DAOFactory.getInstance().getFlightDAO().Update(this);
            }
            catch (DAOException e){
                available = true;
                return false;
            }
        }
        return true;
    }
}
