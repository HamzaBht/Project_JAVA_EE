package com.fligght.beans;

import java.time.LocalDate;

//when the user performs a search query, an instance of this Bean is instantiated to encapsulate the search information
public class SearchQuery {
    public static class SearchDepartureArrivalInfo{
        LocalDate date;
        City city;

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }
    }
    private SearchDepartureArrivalInfo departure;
    private SearchDepartureArrivalInfo arrival;
    private Integer adultsCount;
    private Integer childrenCount;
    private CabineClass cabineClass;

    public SearchDepartureArrivalInfo getDeparture() {
        return departure;
    }

    public void setDeparture(SearchDepartureArrivalInfo departure) {
        this.departure = departure;
    }

    public SearchDepartureArrivalInfo getArrival() {
        return arrival;
    }

    public void setArrival(SearchDepartureArrivalInfo arrival) {
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

    public CabineClass getCabineClass() {
        return cabineClass;
    }

    public void setCabineClass(CabineClass cabineClass) {
        this.cabineClass = cabineClass;
    }
}
