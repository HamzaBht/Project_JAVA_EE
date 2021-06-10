package com.fligght.controllers;

import com.fligght.api.implementations.KamehamehaAPI;
import com.fligght.beans.CabineClass;
import com.fligght.beans.City;
import com.fligght.beans.QueryResult;
import com.fligght.beans.SearchQuery;
import com.fligght.data.FlightProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDate;
import java.util.Collection;

@RequestMapping("/Book")
@Controller
public class SearchRequestController {

    @PostMapping()
    public ModelAndView viewFlights(@RequestParam String from, @RequestParam String to, @RequestParam String departDateReq,
                                    @RequestParam String returnDateReq, @RequestParam String classType)
    {
        SearchQuery query = GetSearchQueryFromRequest(from,to,departDateReq, returnDateReq, classType);
        Collection<QueryResult> results = FlightProvider.GetFlightFromAPI(query);
        if (!results.isEmpty()) {
            return new ModelAndView("/Result","results",results);
        } else {
            return new ModelAndView("/Error");
        }
    }

    private static SearchQuery GetSearchQueryFromRequest(String from, String to,String departDateReq,
                                                  String returnDateReq,String classType){
        LocalDate departDate = (!departDateReq.equals("")) ? LocalDate.parse(departDateReq) : null;
        LocalDate returnDate = (!returnDateReq.equals("")) ? LocalDate.parse(returnDateReq) : null;
        CabineClass cabineClass;
        switch (classType){
            case "Premiere" : cabineClass = CabineClass.FirstClass; break;
            case "Affaire" : cabineClass = CabineClass.BusinessClass; break;
            case "Eco-premium" : cabineClass = CabineClass.PremiumEconomy; break;
            case "Economie" : cabineClass = CabineClass.Economy; break;
            default: cabineClass = CabineClass.OTHER;
        }
        SearchQuery query = new SearchQuery();
        query.setAdultsCount(1);
        query.setChildrenCount(0);
        query.setCabineClass(cabineClass);

        City city = new City();
        city.setName(from);

        SearchQuery.SearchDepartureArrivalInfo departure = new SearchQuery.SearchDepartureArrivalInfo();
        departure.setDate(departDate);
        departure.setCity(city);

        query.setDeparture(departure);

        city = new City();

        city.setName(to);
        SearchQuery.SearchDepartureArrivalInfo arrival = new SearchQuery.SearchDepartureArrivalInfo();
        arrival.setDate(null);
        arrival.setCity(city);

        query.setArrival(arrival);
        String jsonQuery = KamehamehaAPI.getInstance().SearchQueryToJson(query);
        return query;
    }
}
