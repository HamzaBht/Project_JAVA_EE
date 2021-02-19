package com.flight.api.flight_api;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class City {
    public String getName() {
        return name;
    }
    @JsonbCreator
    public City(@JsonbProperty("name") String name) {
        this.name = name;
    }

    private String name;
}