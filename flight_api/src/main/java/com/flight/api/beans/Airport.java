package com.flight.api.beans;

import javax.json.bind.annotation.JsonbTransient;

public class Airport {
    @JsonbTransient
    private int ID;



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private String name;
    private City city;

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }


    public Airport(String name, City city) {
        this.name = name;
        this.city = city;
        this.ID = 0;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
