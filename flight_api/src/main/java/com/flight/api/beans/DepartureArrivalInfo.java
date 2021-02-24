package com.flight.api.beans;


import java.time.LocalDate;
import java.time.LocalTime;

public class DepartureArrivalInfo {

    public DepartureArrivalInfo(LocalDate date, LocalTime hour, Airport airport) {
        this.date = date;
        this.hour = hour;
        this.airport = airport;
    }


    public LocalDate getDate() {
        return date;
    }

    public Airport getAirport() {
        return airport;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    private LocalDate date;


    private LocalTime hour;
    private Airport airport;

}
