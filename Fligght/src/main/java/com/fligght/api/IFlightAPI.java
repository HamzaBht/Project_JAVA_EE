package com.fligght.api;

import com.fligght.beans.Flight;
import com.fligght.beans.SearchQuery;

import java.util.ArrayList;

public interface IFlightAPI {
    default ArrayList<Flight> GetFlights(SearchQuery query){
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

    default Boolean isFilterable()
    {
        return false;
    }
}
