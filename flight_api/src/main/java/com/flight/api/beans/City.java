package com.flight.api.beans;

import javax.json.bind.annotation.JsonbTransient;

public class City {
    public String getName() {
        return name;
    }



    private String name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    @JsonbTransient
    private int ID;
    private Pays pays;
}