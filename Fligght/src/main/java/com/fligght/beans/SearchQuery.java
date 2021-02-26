package com.fligght.beans;

//when the user performs a search query, an instance of this Bean is instantiated to encapsulate the search information
public class SearchQuery {
    private DepartureArrivalInfo departure;
    private DepartureArrivalInfo arrival;
    private Integer adultsCount;
    private Integer childrenCount;
    private String cabineClass;

    public DepartureArrivalInfo getDeparture() {
        return departure;
    }

    public void setDeparture(DepartureArrivalInfo departure) {
        this.departure = departure;
    }

    public DepartureArrivalInfo getArrival() {
        return arrival;
    }

    public void setArrival(DepartureArrivalInfo arrival) {
        this.arrival = arrival;
    }

    public Integer getAdultsCount() {
        return adultsCount;
    }

    public void setAdultsCount(Integer adultsCount) {
        this.adultsCount = adultsCount;
    }

    public Integer getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getCabineClass() {
        return cabineClass;
    }

    public void setCabineClass(String cabineClass) {
        this.cabineClass = cabineClass;
    }
}
