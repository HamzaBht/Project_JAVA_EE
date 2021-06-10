package com.fligght.beans;

public class Flight {
    private int flightNumber;
    private Cabine cabine;
    private DepartureArrivalInfo departureInfo;
    private DepartureArrivalInfo arrivalInfo;
    private Double price;
    private boolean available = false;


    public int getFlightNumber() {
        return flightNumber;
    }
    public DepartureArrivalInfo getDepartureInfo() {
        return departureInfo;
    }
    public DepartureArrivalInfo getArrivalInfo() {
        return arrivalInfo;
    }
    public Double getPrice() {
        return price;
    }
    public void setDepartureInfo(DepartureArrivalInfo departureInfo) {
        this.departureInfo = departureInfo;
    }
    public void setArrivalInfo(DepartureArrivalInfo arrivalInfo) {
        this.arrivalInfo = arrivalInfo;
    }
    public void setPrice(Double price) {
        if (price >= 0.0f) {
            this.price = price;
        }
    }

    public Cabine getCabine() {
        return cabine;
    }

    public void setCabine(Cabine cabine) {
        this.cabine = cabine;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String CalculateDuration(){
        int arrivalHourInMin = arrivalInfo.getHourInMinutes();
        int departHourInMin = departureInfo.getHourInMinutes();
        int diffMinutes;
        if (arrivalHourInMin < departHourInMin)
        {
            diffMinutes = 24*60-departHourInMin + arrivalHourInMin;
        }
        else diffMinutes = arrivalHourInMin - departHourInMin;
        int hours = diffMinutes / 60;
        int minutes = diffMinutes % 60;
        String duration = hours + "h "+ minutes + "min";
        return duration;
    }
}
