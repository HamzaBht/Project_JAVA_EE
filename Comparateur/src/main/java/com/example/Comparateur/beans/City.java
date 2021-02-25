package com.example.Comparateur.beans;



public class City {
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", pays=" + pays +
                '}';
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

    private int ID;
    private Pays pays;
}