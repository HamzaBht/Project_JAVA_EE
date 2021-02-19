package com.flight.api.flight_api;

import java.util.Date;

public class DepartureArrivalInfo {
    public DepartureArrivalInfo() {
        day = "M";
        time = new Date();
        City tanger = new City("Tanger");
        airport = new Airport("TG", tanger);
    }

    public DepartureArrivalInfo(String day, Date time, Airport airport) {
        this.day = day;
        this.time = time;
        this.airport = airport;
    }

    private String day;
    private Date time;
    private Airport airport;

}
