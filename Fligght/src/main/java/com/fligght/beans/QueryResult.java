package com.fligght.beans;

//this bean will hold data for a single query result

public class QueryResult {
    private Flight flight; // the flight result
    private String airlineName; // the corresponding airline
    private String targetWebsiteURL; // the web site we will redirect the user to
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getTargetWebsiteURL() {
        return targetWebsiteURL;
    }

    public void setTargetWebsiteURL(String targetWebsiteURL) {
        this.targetWebsiteURL = targetWebsiteURL;
    }
}
