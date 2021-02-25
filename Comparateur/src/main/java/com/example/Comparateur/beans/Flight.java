package com.example.Comparateur.beans;



public class Flight {



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

    private int flightNumber;

    private Cabine cabine;

    private DepartureArrivalInfo departureInfo;
    private DepartureArrivalInfo arrivalInfo;
    private Double price;
    private boolean available = false;

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", cabine=" + cabine +
                ", departureInfo=" + departureInfo +
                ", arrivalInfo=" + arrivalInfo +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
