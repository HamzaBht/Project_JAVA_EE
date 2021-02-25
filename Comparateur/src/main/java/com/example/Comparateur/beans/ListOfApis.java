package com.example.Comparateur.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListOfApis {
    private List<FLIGHTAPI> flightapiList;

    public ListOfApis(List<FLIGHTAPI> flightapiList) {
        this.flightapiList = flightapiList;
    }
    public List<List<Flight>>FetchFLightsFromList(RequestData requestData) throws IOException, InterruptedException {
        List<List<Flight>> reponse=new ArrayList<>();
        List<Flight> flights=new ArrayList<>();
        for(FLIGHTAPI flightapi:flightapiList){
                flights=flightapi.FetchFlightsFromApi(requestData);
                reponse.add(flights);
        }
        return reponse;
    }
}
