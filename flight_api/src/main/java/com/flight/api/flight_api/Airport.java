package com.flight.api.flight_api;

public class Airport {
    private String code;
    private City city;

    public String getCode() {
        return code;
    }

    public City getCity() {
        return city;
    }


    public Airport(String code,City city) {
        this.code = code;
        this.city = city;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
