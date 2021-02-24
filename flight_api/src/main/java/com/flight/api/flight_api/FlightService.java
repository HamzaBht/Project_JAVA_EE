package com.flight.api.flight_api;

import com.flight.api.beans.Flight;
import com.flight.dao.implementations.*;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/flights")
public class FlightService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GetFlights(){
        DAOFactory airlineDataService = DAOFactory.getInstance();
        Collection<Flight> flights = airlineDataService.getFlightDAO().findAll();
        String result;
        Jsonb jsonb = JsonbBuilder.create();
        result = jsonb.toJson(flights);
        return result;
    }
}
