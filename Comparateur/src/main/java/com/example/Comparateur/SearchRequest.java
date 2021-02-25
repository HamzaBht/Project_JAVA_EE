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

@WebServlet(name = "searchRequest", value = "/SearchRequest")
public class  SearchRequest extends HttpServlet {
    private ListOfApis listOfApis;

    public void init() {
        //exemple
        List<FLIGHTAPI> list=new ArrayList<>();
        list.add(new FLIGHTAPI("http://localhost:8080/api/flights","OngaBunga"));
        listOfApis=new ListOfApis(list);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
      //  PrintWriter out = response.getWriter();
        List<List<Flight>>fLightsFromList=new ArrayList<>();
        RequestData requestData= new RequestData().Getdata(request);


        try {
            fLightsFromList=listOfApis.FetchFLightsFromList(requestData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        request.setAttribute("infos", fLightsFromList);
        request.setAttribute("soso",requestData);


        this.getServletContext().getRequestDispatcher("/Thanks.jsp").forward(request, response);


    }

    public void destroy() {
    }


}