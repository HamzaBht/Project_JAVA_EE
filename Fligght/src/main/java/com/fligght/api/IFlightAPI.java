package com.fligght.api;

import com.fligght.beans.Flight;

import java.util.ArrayList;

public interface IFlightAPI {
    default ArrayList<Flight> GetFlights(){
        return null;
    }
    default String getName(){
        return null;
    }
    default String getURL(){
        return null;
    }
    default String getIconLocation(){
        return null;
    }
}
