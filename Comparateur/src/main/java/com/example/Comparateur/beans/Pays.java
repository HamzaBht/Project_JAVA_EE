package com.example.Comparateur.beans;



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
    private int ID;

    @Override
    public String toString() {
        return "Pays{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
