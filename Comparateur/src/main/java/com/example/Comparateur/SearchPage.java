package com.example.Comparateur;

import com.example.Comparateur.beans.FLIGHTAPI;
import com.example.Comparateur.beans.Flight;
import com.example.Comparateur.beans.ListOfApis;
import com.example.Comparateur.beans.RequestData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="searchPage",value="/Search")
public class SearchPage  extends HttpServlet {
    private ListOfApis listOfApis;

    public void init() {
        //exemple
        List<FLIGHTAPI> list=new ArrayList<>();
        list.add(new FLIGHTAPI("http://localhost:8080/api/flights","OngaBunga"));
        listOfApis=new ListOfApis(list);

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<List<Flight>>fLightsFromList=new ArrayList<>();
        RequestData requestData= new RequestData("","","","","");



        try {
            fLightsFromList=listOfApis.FetchFLightsFromList(requestData);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        List<String>list=new ArrayList<>();
        for(List<Flight> flights : fLightsFromList){
            for(Flight flight:flights) {
                list.add(flight.getDepartureInfo().getAirport().getName());
            }
        }
        request.setAttribute("infos", list );


        this.getServletContext().getRequestDispatcher("/Search.jsp").forward(request, response);
    }
}
