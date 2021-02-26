package com.fligght.beans;


public class Airport {

    private String name;
    private City city;

    public String getName() {
        return name;
    }
    public City getCity() {
        return city;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCity(City city) {
        this.city = city;
    }


    public boolean equals(Airport airport) {
        if (airport == null ) return false;
        return name == airport.getName() && city == airport.getCity();
    }
}
