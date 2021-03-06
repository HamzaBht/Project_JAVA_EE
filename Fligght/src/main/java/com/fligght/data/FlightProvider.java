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
        boolean isCityDepartValid;
        boolean isCityArriveeValid;
        boolean isDateDepartValid;
        boolean isClasseValid;

        for(IFlightAPI flightAPI : flightAPIs){
            ArrayList<Flight> flights;
            try {
                flights =flightAPI.GetFlights();
                for(Flight flight : flights){
                    isCityDepartValid = query.getDeparture().getCity().getName().equals(flight.getDepartureInfo().getAirport().getCity().getName());
                    isCityArriveeValid = query.getArrival().getCity().getName().equals(flight.getArrivalInfo().getAirport().getCity().getName());
                    isDateDepartValid = query.getDeparture().getDate().toString().equals(flight.getDepartureInfo().getDate().toString());
                    isClasseValid = query.getCabineClass() == flight.getCabine().getType();

                    System.out.println(isCityDepartValid+" "+isCityArriveeValid+" "+isDateDepartValid+" "+isClasseValid);
                    System.out.println(query.getDeparture().getCity().getName() + "-->" + flight.getDepartureInfo().getAirport().getCity().getName());
                    System.out.println(query.getArrival().getCity().getName() + "-->" + flight.getArrivalInfo().getAirport().getCity().getName());
                    System.out.println(query.getDeparture().getDate().toString() + "-->" + flight.getDepartureInfo().getDate().toString());
                    System.out.println(query.getCabineClass() + "-->" + flight.getCabine().getType());
                    System.out.println("--------------------------------------------------------");

                    if(isCityArriveeValid && isCityDepartValid &&isDateDepartValid && isClasseValid){
                        QueryResult queryResult = new QueryResult();
                        queryResult.setFlight(flight);
                        queryResult.setAirlineName(flightAPI.getName());
                        queryResult.setTargetWebsiteURL(flightAPI.getURL());
                        queryResult.setIcon(flightAPI.getIconLocation());
                        queryResults.add(queryResult);
                    }
                }
            }
            catch (Exception e){
                continue;
            }
        }

        queryResults.sort(Comparator.comparing(queryResult -> queryResult.getFlight().getPrice()));

        return queryResults;
    }
}
