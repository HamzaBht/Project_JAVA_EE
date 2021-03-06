package com.fligght.beans;


import java.time.LocalDate;
import java.time.LocalTime;

public class DepartureArrivalInfo {
    public int getHourInMinutes(){
        int ans = hour.getHour() * 60 + hour.getMinute();
        return ans;
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
