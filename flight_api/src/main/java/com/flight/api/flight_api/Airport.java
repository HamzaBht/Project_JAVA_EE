package com.flight.api.flight_api;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class Airport {
    private String code;
    private City city;

    public String getCode() {
        return code;
    }

    public City getCity() {
        return city;
    }

    @JsonbCreator
    public Airport(@JsonbProperty("code") String code, @JsonbProperty("city") City city) {
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
