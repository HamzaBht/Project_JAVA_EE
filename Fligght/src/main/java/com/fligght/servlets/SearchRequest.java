package com.fligght.servlets;
import com.fligght.beans.*;
import com.fligght.data.FlightProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
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
        request.setCharacterEncoding("utf-8");
        SearchQuery query = GetSearchQueryFromRequest(request);
        System.out.println(query.getDeparture().getCity().getName());

        Collection<QueryResult> results = FlightProvider.GetFlightFromAPI(query);

        if(!results.isEmpty()){
            request.setAttribute("results", results);


            this.getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);
        }else {
            this.getServletContext().getRequestDispatcher("/Error.jsp").forward(request, response);
        }


    }
    private SearchQuery GetSearchQueryFromRequest(HttpServletRequest request){
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        LocalDate departDate = (!request.getParameter("depart").equals(""))? LocalDate.parse(request.getParameter("depart")) : null;
        LocalDate returnDate = (!request.getParameter("return").equals(""))? LocalDate.parse(request.getParameter("return")) : null;
        String classType = request.getParameter("class");
        CabineClass cabineClass;
        switch (classType){
            case "Premiere" : cabineClass = CabineClass.FirstClass;
            case "Affaire" : cabineClass = CabineClass.BusinessClass;
            case "Eco-premium" : cabineClass = CabineClass.PremiumEconomy;
            case "Economie" : cabineClass = CabineClass.Economy;
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
        return query;
    }

}
