package com.example.Comparateur.beans;


public class Airport {
    private int ID;



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private String name;

    @Override
    public String toString() {
        return "Airport{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }

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
}
