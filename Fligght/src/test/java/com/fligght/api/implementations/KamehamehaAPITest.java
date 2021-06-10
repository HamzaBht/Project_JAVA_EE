package com.fligght.api.implementations;

import com.fligght.beans.CabineClass;
import com.fligght.beans.City;
import com.fligght.beans.Flight;
import com.fligght.beans.SearchQuery;
import com.fligght.controllers.SearchRequestController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class KamehamehaAPITest {

    @Test
    void searchQueryToJson() {
        //create a search query test data
        SearchQuery query = SearchRequestController.GetSearchQueryFromRequest("","","","","");
        String result = KamehamehaAPI.getInstance().SearchQueryToJson(query);
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    void getFlights() {
        SearchQuery query = SearchRequestController.GetSearchQueryFromRequest("","","","","");
        ArrayList<Flight> result = KamehamehaAPI.getInstance().GetFlights(query);
        assertNotNull(result);
        System.out.println("result size : " + result.size());

    }

    @Test
    void getFlightWithClass()
    {
        SearchQuery query = SearchRequestController.GetSearchQueryFromRequest("","","","","Economie");
        ArrayList<Flight> result = KamehamehaAPI.getInstance().GetFlights(query);
        assertNotNull(result);
        System.out.println("result size : " + result.size());
        for (Flight flight : result){
            assertEquals(flight.getCabine().getType(),CabineClass.Economy);
        }
    }

    @Test
    void getFlightWithArrival()
    {
        SearchQuery query = SearchRequestController.GetSearchQueryFromRequest("","Paris","","","");
        ArrayList<Flight> result = KamehamehaAPI.getInstance().GetFlights(query);
        assertNotNull(result);
        System.out.println("result size : " + result.size());
        for (Flight flight : result){
            System.out.println(flight.getArrivalInfo().getAirport().getName().toLowerCase());
            assertTrue(flight.getArrivalInfo().getAirport().getName().toLowerCase().contains("paris"));
        }
    }
    @Test
    void getFlightWithDepart()
    {
        SearchQuery query = SearchRequestController.GetSearchQueryFromRequest("Rabat","","","","");
        ArrayList<Flight> result = KamehamehaAPI.getInstance().GetFlights(query);
        assertNotNull(result);
        System.out.println("result size : " + result.size());
        for (Flight flight : result){
            System.out.println(flight.getDepartureInfo().getAirport().getName().toLowerCase());
            assertTrue(flight.getDepartureInfo().getAirport().getName().toLowerCase().contains("rabat"));
        }
    }
}