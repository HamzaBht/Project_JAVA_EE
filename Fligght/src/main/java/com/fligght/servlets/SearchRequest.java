package com.fligght.servlets;

import com.fligght.beans.CabineClass;
import com.fligght.beans.City;
import com.fligght.beans.QueryResult;
import com.fligght.beans.SearchQuery;
import com.fligght.data.FlightProvider;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

import static com.fligght.beans.CabineClass.*;

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

        if (!results.isEmpty()) {
            request.setAttribute("results", results);
            this.getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);
        } else {
            this.getServletContext().getRequestDispatcher("/Error.jsp").forward(request, response);
        }


    }
    private SearchQuery GetSearchQueryFromRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        LocalDate departDate = LocalDate.parse(request.getParameter("depart"));
        LocalDate returnDate = (!request.getParameter("return").equals("")) ? LocalDate.parse(request.getParameter("return")) : null;
        String classType = request.getParameter("class");
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
        return query;
    }

}
