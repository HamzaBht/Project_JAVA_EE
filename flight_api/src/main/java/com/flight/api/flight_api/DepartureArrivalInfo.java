package com.flight.api.flight_api;


import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DepartureArrivalInfo {

    public DepartureArrivalInfo(Date date, Time hour, Airport airport) {
        this.date = date;
        this.hour = hour;
        this.airport = airport;
    }


    public Date getDate() {
        return date;
    }

    public Airport getAirport() {
        return airport;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    private Date date;


    private Time hour;
    private Airport airport;

}
