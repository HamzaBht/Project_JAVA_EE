package com.flight.api.flight_api;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DepartureArrivalInfo {
    public DepartureArrivalInfo(String day,
                                String time,
                                Airport airport) {
        this.day = day;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.time = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.airport = airport;
    }

    public String getDay() {
        return day;
    }

    public Date getTime() {
        return time;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    private String day;
    private Date time;
    private Airport airport;

}
