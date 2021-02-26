package com.fligght.servlets;
import com.fligght.beans.*;
import com.fligght.data.FlightProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchRequest
 */
@WebServlet("/SearchRequest")
public class SearchRequest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SearchQuery query = GetSearchQueryFromRequest(request);

        Collection<QueryResult> results = FlightProvider.GetFlightFromAPI(query);
        request.setAttribute("results", results);

        this.getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);

    }
    private SearchQuery GetSearchQueryFromRequest(HttpServletRequest request){
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        LocalDate departDate = LocalDate.parse(request.getParameter("depart"));
        LocalDate returnDate = (!request.getParameter("return").equals(""))? LocalDate.parse(request.getParameter("return")) : null;
        String classType = request.getParameter("class");

        SearchQuery query = new SearchQuery();
        query.setAdultsCount(1);
        query.setChildrenCount(0);
        query.setCabineClass(classType);

        Airport airport = new Airport();
        City city = new City();
        city.setName(from);
        Pays pays = new Pays();
        pays.setName("name");
        city.setPays(pays);

        airport.setCity(city);
        airport.setName(from);

        DepartureArrivalInfo departure = new DepartureArrivalInfo();
        departure.setAirport(airport);
        departure.setHour(null);
        departure.setDate(departDate);
        query.setDeparture(departure);

        airport = new Airport();
        city = new City();
        pays = new Pays();

        city.setName(to);
        pays.setName("name");
        city.setPays(pays);

        airport.setCity(city);
        airport.setName(to);
        DepartureArrivalInfo arrival = new DepartureArrivalInfo();
        arrival.setDate(null);
        arrival.setHour(null);
        arrival.setAirport(airport);

        query.setArrival(arrival);
        return query;
    }

}
