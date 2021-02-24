package com.flight.api.beans;

import javax.json.bind.annotation.JsonbTransient;

public class Pays {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private String name;
    @JsonbTransient
    private int ID;
}
