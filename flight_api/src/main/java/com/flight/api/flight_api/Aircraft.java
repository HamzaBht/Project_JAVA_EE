package com.flight.api.flight_api;


public class Aircraft {
    public Aircraft(int totalCapacity, int availablePlaces) {
        this.totalCapacity = totalCapacity;
        this.availablePlaces = availablePlaces;
    }
    public void ResetAvailalePlaces(){
        availablePlaces = totalCapacity;
    }
    public void BookPlaces(int places) throws NotEnoughPlacesLeftException {
        if (places > availablePlaces){
            throw new NotEnoughPlacesLeftException("There is no enough places left");
        }
        availablePlaces -= places;
    }


    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(int availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int totalCapacity;
    private int availablePlaces;
    private int ID;
}
