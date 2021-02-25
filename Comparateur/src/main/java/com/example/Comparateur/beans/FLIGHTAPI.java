package com.example.Comparateur.beans;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class FLIGHTAPI {

     private final String flightApiUrl;
     private final String nomCompagnieAerienne;

    public FLIGHTAPI(String flightApiUrl, String nomCompagnieAerienne) {
        this.flightApiUrl = flightApiUrl;
        this.nomCompagnieAerienne = nomCompagnieAerienne;
    }

    public List<Flight> GetFlightsFromApi( ) throws IOException, InterruptedException {
        HttpClient httpClient=HttpClient.newHttpClient();
        HttpRequest httpRequest=HttpRequest.newBuilder()
                .GET()
                .header("accept","application/json")
                .uri(URI.create(flightApiUrl))
                .build();

        HttpResponse<String> httpResponse=httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());

        //Parse arrivalCity Json
        ObjectMapper mapper =new ObjectMapper();

        return mapper.readValue(httpResponse.body(), new TypeReference<>() {});

    }
    public List<Flight> FetchFlightsFromApi(RequestData requestData) throws IOException, InterruptedException {

        List<Flight> flights=GetFlightsFromApi();
        List<Flight>flightList=new ArrayList<>();
        boolean isCityDepartValide;
        boolean isCityArriveeValide;
        boolean isDateDepartValide;
        boolean isClasseValide;
        String departCity=requestData.getDepartCity();
        String arrivalCity=requestData.getArrivalCity();
        String departDate=requestData.getDateDepart();
        String classe=requestData.getClasse();

        for(Flight flight:flights){

            isCityDepartValide=flight.getDepartureInfo().getAirport().getCity().getName().equalsIgnoreCase(departCity) || departCity=="";

            isCityArriveeValide= flight.getArrivalInfo().getAirport().getCity().getName().equalsIgnoreCase(arrivalCity) || arrivalCity=="" ;

            isDateDepartValide=flight.getDepartureInfo().getDate().toString().equalsIgnoreCase(departDate) || departDate=="";

            isClasseValide=flight.getCabine().getType().equalsIgnoreCase(classe) || classe=="";

            if(isCityArriveeValide && isCityDepartValide && isClasseValide && isDateDepartValide)
                flightList.add(flight);
        }
        return flightList;
    }
}
