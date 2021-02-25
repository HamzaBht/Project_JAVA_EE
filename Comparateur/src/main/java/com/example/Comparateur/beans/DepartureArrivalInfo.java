package com.example.Comparateur.beans;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class DepartureArrivalInfo {



    @Override
    public String toString() {
        return "DepartureArrivalInfo{" +
                "date=" + date +
                ", hour=" + hour +
                ", airport=" + airport +
                '}';
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    private Date date;


    private Time hour;
    private Airport airport;

}
