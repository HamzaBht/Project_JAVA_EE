package com.fligght.beans;


public class City {
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Pays getPays() {
        return pays;
    }
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    private String name;
    private Pays pays;

    public boolean equals(City city){
        if (city == null) return false;
        return name == city.name && pays.getName() == city.getPays().getName();
    }
}