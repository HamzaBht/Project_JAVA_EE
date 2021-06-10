package com.fligght.data;

import com.fligght.api.APIsProvider;
import com.fligght.api.IFlightAPI;
import com.fligght.beans.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Locale;

public class FlightProvider {


    //this methode takes in input the query from the search request, and communicate with the APIs to get flight data
    //then it filters the data to take only the relevant flights, and finally wrap these flights in a QueryResult bean
    //and returns the collection of the QueryResult
    static public Collection<QueryResult> GetFlightFromAPI(SearchQuery query){
        ArrayList<IFlightAPI> flightAPIs;
        ArrayList<QueryResult> queryResults = new ArrayList<>();
        try {
            flightAPIs = APIsProvider.getInstance().getFlightAPIs();
        }
        catch (Exception e){
            return queryResults;
        }
        for(IFlightAPI flightAPI : flightAPIs){
            ArrayList<Flight> flights;
            try {
                flights = flightAPI.GetFlights(query);
                if (flightAPI.isFilterable())
                {
                    flights.forEach(flight -> {
                        QueryResult queryResult = getQueryResult(flightAPI, flight);
                        queryResults.add(queryResult);
                    });
                }
                else {
                    flights.forEach(flight -> {
                        boolean isCityDepartValid;
                        boolean isCityArriveeValid;
                        boolean isDateDepartValid;
                        boolean isClasseValid = (query.getCabineClass() == flight.getCabine().getType());
                        try{
                            isCityDepartValid = query.getDeparture().getCity().getName().equalsIgnoreCase(flight.getDepartureInfo().getAirport().getCity().getName());
                        }
                        catch (Exception e){
                            isCityDepartValid = true;
                        }
                        try{
                            isCityArriveeValid = query.getArrival().getCity().getName().equalsIgnoreCase(flight.getArrivalInfo().getAirport().getCity().getName());
                        }
                        catch (Exception e){
                            isCityArriveeValid = true;
                        }
                        try{
                            isDateDepartValid = query.getDeparture().getDate().equals(flight.getDepartureInfo().getDate());
                        }
                        catch (Exception e){
                            isDateDepartValid = true;
                        }

                        if(isCityDepartValid && isDateDepartValid && isClasseValid){
                            QueryResult queryResult = getQueryResult(flightAPI, flight);
                            queryResults.add(queryResult);
                        }
                    });
                }
            }
            catch (Exception e){
                continue;
            }
        }

        queryResults.sort(Comparator.comparing(queryResult -> queryResult.getFlight().getPrice()));

        return queryResults;
    }

    private static QueryResult getQueryResult(IFlightAPI flightAPI, Flight flight) {
        QueryResult queryResult = new QueryResult();
        queryResult.setFlight(flight);
        queryResult.setAirlineName(flightAPI.getName());
        queryResult.setTargetWebsiteURL(flightAPI.getURL());
        queryResult.setIcon(flightAPI.getIconLocation());
        return queryResult;
    }
}
