package com.fligght.beans;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
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

    public String CalculateDuration(){
        int diffMinutes = arrivalInfo.getHourInMinutes() - departureInfo.getHourInMinutes();
        int hours = diffMinutes / 60;
        int minutes = diffMinutes % 60;
        String duration = hours + "h "+ minutes + "min";
        return duration;
    }

    private int flightNumber;

    private Cabine cabine;

    private DepartureArrivalInfo departureInfo;
    private DepartureArrivalInfo arrivalInfo;
    private Double price;
    private boolean available = false;

}
