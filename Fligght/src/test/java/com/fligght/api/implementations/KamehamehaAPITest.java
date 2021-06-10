package com.fligght.api.implementations;

import com.fligght.beans.CabineClass;
import com.fligght.beans.City;
import com.fligght.beans.SearchQuery;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KamehamehaAPITest {

    SearchQuery createTestQuery()
    {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.setChildrenCount(0);
        searchQuery.setCabineClass(CabineClass.OTHER);
        SearchQuery.SearchDepartureArrivalInfo arrivalInfo = new SearchQuery.SearchDepartureArrivalInfo();
        searchQuery.setArrival(arrivalInfo);
        City city = new City();
        city.setName("Paris");
        arrivalInfo.setCity(city);
        return searchQuery;
    }

    @Test
    void searchQueryToJson() {
        //create a search query test data
        SearchQuery query = createTestQuery();
        String result = KamehamehaAPI.getInstance().SearchQueryToJson(query);
        assertNotNull(result);
        System.out.println(result);
    }

    @Test
    void getFlights() {
        SearchQuery query = createTestQuery();
        ArrayList result = KamehamehaAPI.getInstance().GetFlights(query);
        assertNotNull(result);
        System.out.println("result size : " + result.size());
    }

}