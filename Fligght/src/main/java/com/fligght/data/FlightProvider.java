package com.fligght.data;

import com.fligght.api.APIsProvider;
import com.fligght.api.IFlightAPI;
import com.fligght.beans.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class FlightProvider {


    //this methode takes in input the query from the search request, and communicate with the APIs to get flight dat
    //then it filters the data to take only the relevant flights, and finally wrap these flights in a QueryResult bean
    //and returns the collection of the QueryResult
    static public Collection<QueryResult> GetFlightFromAPI(SearchQuery query){
        ArrayList<QueryResult> queryResults = new ArrayList<>();
        ArrayList<IFlightAPI> flightAPIs = APIsProvider.getInstance().getFlightAPIs();

        boolean isCityDepartValid;
        boolean isCityArriveeValid;
        boolean isDateDepartValid;
        boolean isClasseValid;

        for(IFlightAPI flightAPI : flightAPIs){
            ArrayList<Flight> flights = flightAPI.GetFlights();
            for(Flight flight : flights){
//                isCityArriveeValid = query.getArrival().getAirport() == null || (flight.getArrivalInfo().getAirport().equals(query.getArrival().getAirport()));
//                isCityDepartValid = query.getDeparture().getAirport() == null || (flight.getDepartureInfo().getAirport().equals(query.getDeparture().getAirport()));
//                isDateDepartValid = (query.getDeparture().getDate() !=null
//                        && (query.getDeparture().getDate().isAfter(LocalDate.now())) || (query.getDeparture().getDate().isBefore(flight.getDepartureInfo().getDate())));
//                isClasseValid = flight.getCabine().getType().equalsIgnoreCase(query.getCabineClass());
//
//                if (flight.isAvailable() && isCityArriveeValid && isCityDepartValid && isDateDepartValid && isClasseValid){
//                    QueryResult queryResult = new QueryResult();
//                    queryResult.setFlight(flight);
//                    queryResult.setAirlineName(flightAPI.getName());
//                    queryResult.setTargetWebsiteURL(flightAPI.getURL());
//                    queryResult.setIcon(flightAPI.getIconLocation());
//
//                    queryResults.add(queryResult);
//                }
                QueryResult queryResult = new QueryResult();
                queryResult.setFlight(flight);
                queryResult.setAirlineName(flightAPI.getName());
                queryResult.setTargetWebsiteURL(flightAPI.getURL());
                queryResult.setIcon(flightAPI.getIconLocation());
                queryResults.add(queryResult);
            }
        }

        queryResults.sort(Comparator.comparing(queryResult -> queryResult.getFlight().getPrice()));

        return queryResults;
    }
}
